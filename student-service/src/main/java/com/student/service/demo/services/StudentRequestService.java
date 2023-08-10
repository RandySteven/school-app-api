package com.student.service.demo.services;

import com.student.service.demo.entity.payloads.StudentRequest;

import java.util.List;

public interface StudentRequestService {

    List<StudentRequest> getAllStudentRequests();
    StudentRequest getStudentRequestById(String id);
    StudentRequest saveStudentRequest(StudentRequest studentRequest);
    int getAllStudentRequestsSize();

}
