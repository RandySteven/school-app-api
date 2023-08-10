package com.teacher.service.demo.entity.model;

import com.teacher.service.demo.enums.TeacherBachelorDegree;
import com.teacher.service.demo.enums.TeacherStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "teachers")
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    private String teacherId;
    private String teacherName;
    private String teacherEmail;
    private String teacherPassword;
    private Address teacherAddress;
    private String teacherPhoneNumber;
    private Date teacherDob;
    private TeacherBachelorDegree teacherBachelorDegree;
    private TeacherStatus teacherStatus;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public Teacher setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public Teacher setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
        return this;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this;
    }

    public Address getTeacherAddress() {
        return teacherAddress;
    }

    public Teacher setTeacherAddress(Address teacherAddress) {
        this.teacherAddress = teacherAddress;
        return this;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public Teacher setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
        return this;
    }

    public Date getTeacherDob() {
        return teacherDob;
    }

    public Teacher setTeacherDob(Date teacherDob) {
        this.teacherDob = teacherDob;
        return this;
    }

    public TeacherBachelorDegree getTeacherBachelorDegree() {
        return teacherBachelorDegree;
    }

    public Teacher setTeacherBachelorDegree(TeacherBachelorDegree teacherBachelorDegree) {
        this.teacherBachelorDegree = teacherBachelorDegree;
        return this;
    }

    public TeacherStatus getTeacherStatus() {
        return teacherStatus;
    }

    public Teacher setTeacherStatus(TeacherStatus teacherStatus) {
        this.teacherStatus = teacherStatus;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Teacher setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Teacher setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public Teacher setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public Teacher(){}
}
