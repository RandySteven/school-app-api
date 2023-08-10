package com.teacher.service.demo.services;

import com.teacher.service.demo.entity.payload.TeacherRequest;

import java.util.List;

public interface TeacherRequestService {

    TeacherRequest sendTeacherRequest(TeacherRequest teacherRequest);
    List<TeacherRequest> getAllTeacherRequests();
    TeacherRequest getTeacherRequestByRequestId(String requestId);
    TeacherRequest updateTeacherRequest(TeacherRequest teacherRequest);

}
