package com.student.service.demo.services;

import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);
    List<Student> registerMultipleStudent(StudentRequest[] studentRequest);
    List<Student> getAllStudentList();
    Student updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentByStudentId(String studentId);
}
