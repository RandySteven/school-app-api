package com.teacher.service.demo.services.impl;

import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.repositories.mongodb.TeacherRequestRepository;
import com.teacher.service.demo.services.TeacherRequestService;
import com.teacher.service.demo.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherRequestServiceImpl implements TeacherRequestService {

    @Autowired
    TeacherRequestRepository teacherRequestRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherRequestServiceImpl.class);

    @Override
    public TeacherRequest sendTeacherRequest(TeacherRequest teacherRequest) {
        return teacherRequestRepository.insert(teacherRequest);
    }

    @Override
    public List<TeacherRequest> getAllTeacherRequests() {
        return null;
    }

    @Override
    public TeacherRequest getTeacherRequestByRequestId(String requestId) {
        return null;
    }

    @Override
    public TeacherRequest updateTeacherRequest(TeacherRequest teacherRequest) {
        return teacherRequestRepository.save(teacherRequest);
    }
}
