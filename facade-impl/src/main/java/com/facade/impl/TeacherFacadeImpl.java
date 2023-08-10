package com.facade.impl;

import com.module.common.utils.VelocityUtil;
import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.entity.payload.TeacherResult;
import com.teacher.service.demo.enums.TeacherRequestStatus;
import com.teacher.service.demo.facades.TeacherFacade;
import com.teacher.service.demo.services.TeacherRequestService;
import com.teacher.service.demo.services.TeacherService;
import com.teacher.service.demo.utils.TeacherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TeacherFacadeImpl implements TeacherFacade {

    @Autowired
    TeacherRequestService teacherRequestService;

    @Autowired
    TeacherService teacherService;

    TeacherUtil teacherUtil = TeacherUtil.getInstance();

    VelocityUtil velocityUtil = VelocityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherFacadeImpl.class);

    @Override
    @Async
    public CompletableFuture<String> registerNewTeacher(TeacherRequest teacherRequest) {
        LOGGER.info("================== Register Teacher Method ==================");
        teacherRequest.setTeacherRequestStatus(TeacherRequestStatus.PENDING);
        teacherRequestService.sendTeacherRequest(teacherRequest);
        Teacher teacher = teacherUtil.teacherRequestToTeacherModel(teacherRequest);
        String teacherId = velocityUtil.generateTeacherId(teacherRequest, teacherRequestService.getAllTeacherRequests().size());
        teacher.setTeacherId(teacherId);
        teacherService.registerNewTeacher(teacher);
        if(teacher.getTeacherId().length()!=0){
            teacherRequest.setTeacherRequestStatus(TeacherRequestStatus.SUCCESS);
        }else{
            teacherRequest.setTeacherRequestStatus(TeacherRequestStatus.FAILED);
        }
        teacherRequestService.updateTeacherRequest(teacherRequest);
        return CompletableFuture.completedFuture(teacher.getTeacherId());
    }

    @Override
    public List<TeacherResult> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return teacherUtil.getAllTeacherResults(teachers);
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return null;
    }

    @Override
    public Teacher updateTeacherByTeacherId(String teacherId, TeacherRequest teacherRequest) {
        return null;
    }
}
