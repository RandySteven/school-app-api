package com.course.service.demo.entity.payload.result;

import com.course.service.demo.entity.model.Course;

public class CourseResult {

    private String courseName;
    private String url;

    public CourseResult(Course course){
        this.courseName = course.getCourseName();
        this.url = "http://localhost:8082/v1/courses/" + course.getCourseId();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CourseResult(){}
}
