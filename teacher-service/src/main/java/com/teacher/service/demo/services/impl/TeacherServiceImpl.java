package com.teacher.service.demo.services.impl;

import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);


    @Override
    public Teacher registerNewTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return null;
    }

    @Override
    public Teacher updateNewTeacher(TeacherRequest teacherRequest) {
        return null;
    }

    @Override
    public void deleteTeacherByTeacherId(String teacherId) {

    }
}
