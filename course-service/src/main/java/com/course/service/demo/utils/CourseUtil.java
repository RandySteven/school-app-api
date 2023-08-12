package com.course.service.demo.utils;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.entity.payload.result.SubjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseUtil {

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

}
