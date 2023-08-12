package com.teacher.service.demo.repositories.mysql;

import com.teacher.service.demo.entity.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByTeacherId(String teacherId);
}
