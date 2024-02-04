package com.score.service.demo.entity.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ScoreId implements Serializable {

    private static final long serialVersionUID = 7184294874682649392L;

    private String studentId;
    private String courseId;

    public ScoreId(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
