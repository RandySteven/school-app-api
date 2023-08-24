package com.course.service.demo.entity.payload.request;

import com.course.service.demo.enums.Grade;

public class CourseRequest {

    private String courseName;
    private String courseDescription;
    private Grade grade;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public CourseRequest(){}
}
