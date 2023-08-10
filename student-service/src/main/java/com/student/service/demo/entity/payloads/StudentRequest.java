package com.student.service.demo.entity.payloads;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * <h1>Payload of StudentRequest</h1>
 *
 * @created_by: <b>Randy Steven</b>
 * {
 *     "studentName": "John Cena",
 *     "studentEmail": "john.cena@school.com",
 *     "studentPassword": "schoolName11042001",
 *     "studentFatherName": "Uzumaki Naruto",
 *     "studentMotherName": "Uchiha Saskeh",
 *     "studentDob": "11-04-2001"
 * }
 */
@Document("student_request")
public class StudentRequest {

    @MongoId
    private String requestId;
    private String studentName;
    private String studentEmail;
    private String studentPassword;
    private String studentDob;
    private String studentFatherName;
    private String studentMotherName;

    public StudentRequest(String requestId,
                          String studentName,
                          String studentEmail,
                          String studentPassword,
                          String studentDob,
                          String studentFatherName,
                          String studentMotherName
    ) {
        this.requestId = requestId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.studentDob = studentDob;
        this.studentFatherName = studentFatherName;
        this.studentMotherName = studentMotherName;
    }

    public StudentRequest(){}

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
    }

    public String getStudentMotherName() {
        return studentMotherName;
    }

    public void setStudentMotherName(String studentMotherName) {
        this.studentMotherName = studentMotherName;
    }
}
