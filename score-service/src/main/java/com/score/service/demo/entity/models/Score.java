package com.score.service.demo.entity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="scores")
@IdClass(ScoreId.class)
public class Score {

    @Id
    private String studentId;
    @Id
    private String courseId;
    private float score;

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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Score(){}

    public Score(String studentId, String courseId, float score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }
}
