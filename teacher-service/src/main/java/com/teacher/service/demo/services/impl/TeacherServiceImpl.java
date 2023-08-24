package com.teacher.service.demo.services.impl;

import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.repositories.mysql.TeacherRepository;
import com.teacher.service.demo.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher registerNewTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return teacherRepository.findTeacherByTeacherId(teacherId);
    }

    @Override
    public Teacher updateNewTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacherByTeacherId(String teacherId) {

    }
}
