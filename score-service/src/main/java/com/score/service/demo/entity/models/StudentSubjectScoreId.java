package com.score.service.demo.entity.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentSubjectScoreId {

    private String studentId;
    private String subjectId;

    public StudentSubjectScoreId(){}

    public StudentSubjectScoreId(String studentId, String subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
