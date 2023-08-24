package com.teacher.service.demo.services;

import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;

import java.util.List;

public interface TeacherService{

    Teacher registerNewTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherByTeacherId(String teacherId);
    Teacher updateNewTeacher(Teacher teacher);
    void deleteTeacherByTeacherId(String teacherId);

}
