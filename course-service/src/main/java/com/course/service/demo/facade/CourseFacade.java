package com.course.service.demo.facade;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.enums.Grade;

import java.util.List;

public interface CourseFacade {

    String addCourse(Course course, Grade grade);
    List<CourseResult> getAllCourseResults();
    CourseDTO getCourseByCourseId(String courseId);

}
