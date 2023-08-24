package com.course.service.demo.utils;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.entity.payload.request.CourseRequest;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.entity.payload.result.SubjectResult;
import com.course.service.demo.enums.Grade;
import com.module.common.utils.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseUtil {

    VelocityUtil vu = VelocityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseUtil.class);

    public CourseResult courseToCourseResult(Course course){
        return new CourseResult(course);
    }

    public CourseDTO getCourseDTO(Course course, List<Subject> subjects){
        List<SubjectResult> subjectResults = new ArrayList<>();
        subjects.forEach(subject -> {
            if(subject.getCourseId().equals(course.getCourseId())){
                subjectResults.add(subjectToSubjectResult(subject));
            }
        });
        return new CourseDTO(course, subjectResults);
    }

    public Course courseRequestToCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseDetail(courseRequest.getCourseDescription());
        return course;
    }

    public SubjectResult subjectToSubjectResult(Subject subject){
        return new SubjectResult(subject);
    }

    public List<SubjectResult> subjectsToSubjectResultList(List<Subject> subjects){
        List<SubjectResult> subjectResults = new ArrayList<>();
        subjects.forEach(subject -> {
            subjectResults.add(subjectToSubjectResult(subject));
        });
        return subjectResults;
    }

    /**
     *
     * @param course
     * courseId = CRS + (first 3 chars from course name) + (grade / level [09|10|11|12]) + randomDigits(6)
     * sample :
     * courseId = CRSMAT10123456
     * @return
     */
    public String generateCourseId(Course course, Grade grade){
        String firstThreeChars = course.getCourseName().substring(0, 3);
        String courseId = "CRS" + firstThreeChars + grade.getNumber() + vu.generateDigitsNumber(6);
        return courseId;
    }

    public String subjectId(){
        String randomAlphaNumb = vu.generateAlphaNumeric(13);
        return "SUB" + randomAlphaNumb;
    }
}
