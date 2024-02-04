package com.score.service.demo.service.impl;

import com.score.service.demo.entity.models.StudentSubjectScore;
import com.score.service.demo.repository.StudentSubjectScoreRepository;
import com.score.service.demo.service.StudentSubjectScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSubjectScoreServiceImpl implements StudentSubjectScoreService {

    @Autowired
    StudentSubjectScoreRepository studentSubjectScoreRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSubjectScoreServiceImpl.class);

    @Override
    public void addStudentSubjectScore(StudentSubjectScore studentSubjectScore) {
        studentSubjectScoreRepository.save(studentSubjectScore);
    }

    @Override
    public List<StudentSubjectScore> getAllSubjectScoresByStudentId(String studentId) {
        return null;
    }
}
