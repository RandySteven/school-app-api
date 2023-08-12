package com.course.service.demo.services;

import com.course.service.demo.entity.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);
    List<Subject> getAllSubjects();
    Subject updateSubject(Subject subject);
}
