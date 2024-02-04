package com.score.service.demo.service;

import com.score.service.demo.entity.models.StudentSubjectScore;

import java.util.List;

public interface StudentSubjectScoreService {

    void addStudentSubjectScore(StudentSubjectScore studentSubjectScore);
    List<StudentSubjectScore> getAllSubjectScoresByStudentId(String studentId);
}
