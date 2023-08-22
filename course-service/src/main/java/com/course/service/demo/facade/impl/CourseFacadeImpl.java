package com.course.service.demo.facade.impl;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
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

import java.util.List;

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
    public List<CourseResult> getAllCourseResults() {
        return null;
    }

    @Override
    public CourseDTO getCourseByCourseId(String courseId) {
        Course course = courseService.getCourseByCourseId(courseId);
        List<Subject> subjects = subjectService.getAllSubjects();
        CourseDTO courseDTO = courseUtil.getCourseDTO(course, subjects);
        return courseDTO;
    }

}
