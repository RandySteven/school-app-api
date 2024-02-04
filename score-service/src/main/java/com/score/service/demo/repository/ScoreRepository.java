package com.score.service.demo.repository;

import com.score.service.demo.entity.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, String> {
}
