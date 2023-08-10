package com.teacher.service.demo.facades;

import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.entity.payload.TeacherResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TeacherFacade {

    CompletableFuture<String> registerNewTeacher(TeacherRequest teacherRequest);
    List<TeacherResult> getAllTeachers();
    Teacher getTeacherByTeacherId(String teacherId);
    Teacher updateTeacherByTeacherId(String teacherId, TeacherRequest teacherRequest);

}
