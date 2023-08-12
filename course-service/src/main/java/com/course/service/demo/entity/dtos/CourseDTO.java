package com.course.service.demo.entity.dtos;

import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.entity.payload.result.SubjectResult;

import java.util.List;

public class CourseDTO {

    private String courseId;
    private String courseName;
    private String courseDescription;
    private List<SubjectResult> subjects;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

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

    public List<SubjectResult> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectResult> subjects) {
        this.subjects = subjects;
    }

    public CourseDTO(String courseId, String courseName, String courseDescription, List<SubjectResult> subjects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.subjects = subjects;
    }

    public CourseDTO(Course course, List<SubjectResult> subjects){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.courseDescription = course.getCourseDetail();
        this.subjects = subjects;
    }

}
