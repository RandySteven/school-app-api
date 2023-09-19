package com.student.service.demo.services.impl;

import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.repositories.mongodb.StudentRequestRepository;
import com.student.service.demo.repositories.mysql.StudentRepository;
import com.student.service.demo.services.StudentService;
import com.student.service.demo.utils.ErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentRequestRepository studentRequestRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentRequestRepository studentRequestRepository){
        this.studentRepository = studentRepository;
        this.studentRequestRepository = studentRequestRepository;
    }

    ErrorHandler errorHandler = ErrorHandler.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student registerStudent(Student student) {
        student = studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> registerMultipleStudent(StudentRequest[] studentRequest) {
        return null;
    }

    @Override
    public List<Student> getAllStudentList() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student updateStudent(Student student) {
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(Student student) {
        student.setDeletedAt(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

}
