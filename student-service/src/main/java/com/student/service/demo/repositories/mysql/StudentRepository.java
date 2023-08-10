package com.student.service.demo.repositories.mysql;

import com.student.service.demo.entity.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId);
}
