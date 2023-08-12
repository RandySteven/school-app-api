package com.course.service.demo.services;

import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.payload.result.CourseResult;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);
    List<Course> getAllCourses();
    Course updateCourse(Course course);
    Course getCourseByCourseId(String courseId);
    void deleteCourseByCourseId(String courseId);

}
