package com.course.service.demo.services.impl;

import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.repository.SubjectRepository;
import com.course.service.demo.services.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SubjectServiceImpl implements SubjectService, Serializable {

    @Serial
    private static final long serialVersionUID = 9062807374850884890L;

    @Autowired
    SubjectRepository subjectRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }
}
