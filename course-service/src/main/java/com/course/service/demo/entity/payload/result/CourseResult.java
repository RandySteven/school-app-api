package com.course.service.demo.entity.payload.result;

import com.course.service.demo.entity.model.Course;

public class CourseResult {

    private String courseName;
    private String url;

    public CourseResult(Course course){
        this.courseName = course.getCourseName();
        this.url = "http://localhost:8082/v1/courses/" + course.getCourseId();
    }

}
