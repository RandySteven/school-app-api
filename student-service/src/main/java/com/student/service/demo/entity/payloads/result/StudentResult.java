package com.student.service.demo.entity.payloads.result;


import com.student.service.demo.entity.models.Student;
import com.student.service.demo.enums.StudentStatus;

public class StudentResult {

    private String studentName;
    private String studentEmail;
    private String url;
    private StudentStatus studentStatus;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public StudentResult(Student student){
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.url = "http://localhost:8080/v1/students/" + student.getStudentId();
        this.studentStatus = student.getStudentStatus();
    }

}
