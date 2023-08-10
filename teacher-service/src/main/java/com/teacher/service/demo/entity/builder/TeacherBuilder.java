package com.teacher.service.demo.entity.builder;

import com.teacher.service.demo.entity.model.Address;
import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.enums.TeacherBachelorDegree;
import com.teacher.service.demo.enums.TeacherStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class TeacherBuilder {

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
        return this.builder();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this.builder();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this.builder();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public Teacher setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
        return this.builder();
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this.builder();
    }

    public Address getTeacherAddress() {
        return teacherAddress;
    }

    public Teacher setTeacherAddress(Address teacherAddress) {
        this.teacherAddress = teacherAddress;
        return this.builder();
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public Teacher setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
        return this.builder();
    }

    public Date getTeacherDob() {
        return teacherDob;
    }

    public Teacher setTeacherDob(Date teacherDob) {
        this.teacherDob = teacherDob;
        return this.builder();
    }

    public TeacherBachelorDegree getTeacherBachelorDegree() {
        return teacherBachelorDegree;
    }

    public Teacher setTeacherBachelorDegree(TeacherBachelorDegree teacherBachelorDegree) {
        this.teacherBachelorDegree = teacherBachelorDegree;
        return this.builder();
    }

    public TeacherStatus getTeacherStatus() {
        return teacherStatus;
    }

    public Teacher setTeacherStatus(TeacherStatus teacherStatus) {
        this.teacherStatus = teacherStatus;
        return this.builder();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Teacher setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this.builder();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Teacher setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this.builder();
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public Teacher setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this.builder();
    }

    public Teacher builder(){
        return new Teacher();
    }
    
}
