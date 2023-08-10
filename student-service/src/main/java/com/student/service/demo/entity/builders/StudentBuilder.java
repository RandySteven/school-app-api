package com.student.service.demo.entity.builders;

import com.student.service.demo.entity.models.Student;
import com.student.service.demo.enums.StudentStatus;

import java.sql.Date;
import java.time.LocalDateTime;

public class StudentBuilder {

    private Long id;
    private String studentId;
    private String studentName;
    private Date studentDob;
    private String studentEmail;
    private String studentPassword;
    private String studentFatherName;
    private String studentMotherName;
    private StudentStatus studentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Student build(){
        return new Student();
    }

    public Student setId(Long id) {
        this.build().setId(id);
        return this.build();
    }

    public Student setStudentId(String studentId) {
        this.build().setStudentId(studentId);
        return this.build();
    }

    public Student setStudentName(String studentName) {
        this.build().setStudentName(studentName);
        return this.build();
    }

    public Student setStudentDob(Date studentDob) {
        this.build().setStudentDob(studentDob);
        return this.build();
    }

    public Student setStudentEmail(String studentEmail) {
        this.build().setStudentEmail(studentEmail);
        return this.build();
    }

    public Student setStudentPassword(String studentPassword) {
        this.build().setStudentPassword(studentPassword);
        return this.build();
    }

    public Student setStudentFatherName(String studentFatherName) {
        this.build().setStudentFatherName(studentFatherName);
        return this.build();
    }

    public Student setStudentMotherName(String studentMotherName) {
        this.build().setStudentMotherName(studentMotherName);
        return this.build();
    }

    public Student setStudentStatus(StudentStatus studentStatus) {
        this.build().setStudentStatus(studentStatus);
        return this.build();
    }

    public Student setCreatedAt(LocalDateTime createdAt) {
        this.build().setCreatedAt(createdAt);
        return this.build();
    }

    public Student setUpdatedAt(LocalDateTime updatedAt) {
        this.build().setUpdatedAt(updatedAt);
        return this.build();
    }

    public Student setDeletedAt(LocalDateTime deletedAt) {
        this.build().setDeletedAt(deletedAt);
        return this.build();
    }
}
