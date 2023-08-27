package com.teacher.service.demo.entity.payload;

import com.teacher.service.demo.entity.model.Address;
import com.teacher.service.demo.enums.TeacherBachelorDegree;
import com.teacher.service.demo.enums.TeacherRequestStatus;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "teachers")
public class TeacherRequest {

    @MongoId
    private String requestId;

    private String teacherName;
    private String teacherEmail;
    private String teacherPassword;
    private String teacherPhoneNumber;
    private String teacherAddress;

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    private TeacherRequestStatus teacherRequestStatus;
    private TeacherBachelorDegree teacherBachelorDegree;

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public TeacherRequestStatus getTeacherRequestStatus() {
        return teacherRequestStatus;
    }

    public void setTeacherRequestStatus(TeacherRequestStatus teacherRequestStatus) {
        this.teacherRequestStatus = teacherRequestStatus;
    }

    public TeacherBachelorDegree getTeacherBachelorDegree() {
        return teacherBachelorDegree;
    }

    public void setTeacherBachelorDegree(TeacherBachelorDegree teacherBachelorDegree) {
        this.teacherBachelorDegree = teacherBachelorDegree;
    }

    private String teacherDob;
    private Address address;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDob() {
        return teacherDob;
    }

    public void setTeacherDob(String teacherDob) {
        this.teacherDob = teacherDob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTeacherPhoneNumber(){
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber){
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public TeacherRequest(){}
}
