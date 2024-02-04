package com.score.service.demo.entity.payloads.request;

public class StudentSubjectScoreRequest {

    private String studentId;
    private String subjectId;
    private float score;

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

    public StudentSubjectScoreRequest(String studentId, String subjectId, float score) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }
}
