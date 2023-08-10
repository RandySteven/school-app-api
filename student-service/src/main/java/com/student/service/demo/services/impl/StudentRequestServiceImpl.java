package com.student.service.demo.services.impl;

import com.module.common.utils.VelocityUtil;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.repositories.mongodb.StudentRequestRepository;
import com.student.service.demo.services.StudentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRequestServiceImpl implements StudentRequestService {

    @Autowired
    StudentRequestRepository studentRequestRepository;

    VelocityUtil vu = VelocityUtil.getInstance();


    @Override
    public List<StudentRequest> getAllStudentRequests() {
        List<StudentRequest> studentRequestList = studentRequestRepository.findAll();
        return studentRequestList;
    }

    @Override
    public StudentRequest getStudentRequestById(String _id) {
        Optional<StudentRequest> studentRequest = studentRequestRepository.findById(_id);
        return studentRequest.get();
    }

    @Override
    public StudentRequest saveStudentRequest(StudentRequest studentRequest) {
        studentRequest = studentRequestRepository.save(studentRequest);
        return studentRequest;
    }

    @Override
    public int getAllStudentRequestsSize() {
        return getAllStudentRequests().size();
    }

}
