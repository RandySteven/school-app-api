package com.score.service.demo.repository;

import com.score.service.demo.entity.models.StudentSubjectScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectScoreRepository extends JpaRepository<StudentSubjectScore, String> {
}
