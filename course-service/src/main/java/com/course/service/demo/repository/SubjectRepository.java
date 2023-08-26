package com.course.service.demo.repository;

import com.course.service.demo.entity.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findSubjectBySubjectId(String subjectId);
}
