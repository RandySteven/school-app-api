package com.teacher.service.demo.entity.payload;

import com.teacher.service.demo.entity.model.Address;
import com.teacher.service.demo.entity.model.Teacher;

public class TeacherResult {

    private String teacherName;
    private String teacherEmail;
    private String teacherPhoneNumber;
    private Address teacherAddress;
    private String url;

    public TeacherResult(Teacher teacher){
        this.teacherName = teacher.getTeacherName();
        this.teacherEmail = teacher.getTeacherEmail();
        this.teacherPhoneNumber = teacher.getTeacherPhoneNumber();
        this.teacherAddress = teacher.getTeacherAddress();
        this.url = "http://localhost:8080/v1/teachers/"+teacher.getTeacherId();
    }

}
