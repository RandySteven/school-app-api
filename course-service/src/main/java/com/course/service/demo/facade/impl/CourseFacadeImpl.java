package com.course.service.demo.facade.impl;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.entity.payload.request.CourseRequest;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.enums.Grade;
import com.course.service.demo.facade.CourseFacade;
import com.course.service.demo.services.CourseService;
import com.course.service.demo.services.SubjectService;
import com.course.service.demo.utils.CourseUtil;
import com.module.common.utils.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseFacadeImpl implements CourseFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseFacadeImpl.class);

    @Autowired
    CourseService courseService;

    @Autowired
    SubjectService subjectService;

    VelocityUtil vu = VelocityUtil.getInstance();

    CourseUtil courseUtil = new CourseUtil();

    @Override
    public String addCourse(Course course, Grade grade) {
        String courseId = courseUtil.generateCourseId(course, grade);
        course.setCourseId(courseId);
        courseService.addCourse(course);
        return course.getCourseId();
    }

    @Override
    public String addCourse(CourseRequest request) {
        Course course = courseUtil.courseRequestToCourse(request);
        Grade grade = request.getGrade();
        String courseId = courseUtil.generateCourseId(course, grade);
        course.setCourseId(courseId);
        courseService.addCourse(course);
        return course.getCourseId();
    }

    @Override
    public List<CourseResult> getAllCourseResults() {
        List<Course> courses = courseService.getAllCourses();
        List<CourseResult> courseResults = courseUtil.coursesToCourseResults(courses);
        return courseResults;
    }

    @Override
    public CourseDTO getCourseByCourseId(String courseId) {
        Course course = courseService.getCourseByCourseId(courseId);
        LOGGER.info("=== course : " + course.getCourseName());
        List<Subject> subjects = subjectService.getAllSubjects();
        CourseDTO courseDTO = courseUtil.getCourseDTO(course, subjects);
        LOGGER.info("=== courseDTO : " + courseDTO);
        return courseDTO;
    }

    @Override
    public String addSubject(String courseId, Subject subject) {
        if(!courseService.checkCourseExist(courseId)){
            return "";
        }
        subject.setCourseId(courseId);
        subject.setSubjectId(courseUtil.subjectId());
        subjectService.addSubject(subject);
        return subject.getSubjectId();
    }

    @Override
    public Subject getSubjectBySubjectId(String subjectId) {
        Subject subject = subjectService.getSubjectBySubjectId(subjectId);
        if(subject != null){
            return subject;
        }
        return null;
    }

}
