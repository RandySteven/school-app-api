package com.student.service.demo.entity.models;

import com.student.service.demo.enums.StudentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * &#064;created  : <b>Randy Steven</b>
 * Explanation :
 * <p>Model for student at database</p>
 */
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;
    /**
     * @StudentId
     * <h2>rules :</h2>
     * <ol>
     * <li>4 first digits is current year => 2023</li>
     * <li>3 digits is the increment of register student => 001 --> 999 : max 999 students</li>
     * <li>next 6 digits is student dd/mm/yy => 110401</li>
     * <li>6 is current date 290723 when admin input the data</li>
     * <li>STD2023001110401290723</li>
     * </ol>
     */
    private String studentId;
    private String studentName;
    private Date studentDob;
    /**
     * sample : randy.steven@school.id
     */
    private String studentEmail;
    /**
     * Password rules :
     * <ol>
     *     <li>input : userRequest.password + userRequest.dob + encryptionKey</li>
     * </ol>
     */
    private String studentPassword;
    private String studentFatherName;
    private String studentMotherName;
//    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public Student setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Date getStudentDob() {
        return studentDob;
    }

    public Student setStudentDob(Date studentDob) {
        this.studentDob = studentDob;
        return this;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public Student setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
        return this;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public Student setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
        return this;
    }

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public Student setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
        return this;
    }

    public String getStudentMotherName() {
        return studentMotherName;
    }

    public Student setStudentMotherName(String studentMotherName) {
        this.studentMotherName = studentMotherName;
        return this;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public Student setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Student setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Student setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public Student setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public Student(){}



}
