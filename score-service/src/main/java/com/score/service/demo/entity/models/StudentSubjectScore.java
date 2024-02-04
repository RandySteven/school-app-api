package com.score.service.demo.entity.models;

import jakarta.persistence.*;

@Entity
@Table(name="student_subject_scores")
@IdClass(StudentSubjectScoreId.class)
public class StudentSubjectScore {

    @Id
    private String studentId;
    @Id
    private String subjectId;
    private float score;

    public StudentSubjectScore(){}

    public StudentSubjectScore(String studentId, String subjectId, float score) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
