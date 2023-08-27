package com.teacher.service.demo.utils;

import com.module.common.utils.SecurityUtil;
import com.module.common.utils.VelocityUtil;
import com.teacher.service.demo.entity.builder.TeacherBuilder;
import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.entity.payload.TeacherResult;
import com.teacher.service.demo.enums.TeacherStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = -2356338775834880541L;

    public static TeacherUtil getInstance(){
        return new TeacherUtil();
    }

    SecurityUtil su = SecurityUtil.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    public Teacher teacherRequestToTeacherModel(TeacherRequest teacherRequest){
        return new TeacherBuilder().builder()
                .setTeacherName(teacherRequest.getTeacherName())
                .setTeacherEmail(teacherRequest.getTeacherEmail())
                .setTeacherPassword(teacherRequest.getTeacherPassword())
                .setTeacherDob(vu.getDateRequest(teacherRequest.getTeacherDob()))
                .setTeacherStatus(TeacherStatus.NORMAL)
                .setTeacherAddress(teacherRequest.getTeacherAddress())
                .setTeacherPhoneNumber(teacherRequest.getTeacherPhoneNumber());
    }

    public TeacherResult teacherModelToTeacherResult(Teacher teacher){
        return new TeacherResult(teacher);
    }

    public List<TeacherResult> getAllTeacherResults(List<Teacher> teachers){
        List<TeacherResult> teacherResults = new ArrayList<>();
        teachers.forEach(teacher -> {
            teacherResults.add(teacherModelToTeacherResult(teacher));
        });
        teachers.clear();
        return teacherResults;
    }

    public List<TeacherResult> getAvailTeacherResults(List<Teacher> teachers){
        List<TeacherResult> teacherResults = new ArrayList<>();
        teachers.forEach(teacher -> {
            if(teacher.getDeletedAt() != null){
                teacherResults.add(teacherModelToTeacherResult(teacher));
            }
        });
        teachers.clear();
        return teacherResults;
    }

    public String generateTeacherId(TeacherRequest teacherRequest, int totalRequestedTeacher){
        String year = vu.getCurrentYear();
        String currDate = vu.getCurrentDateTime();
        String requestedTotalStr = "";
        if(totalRequestedTeacher < 10){
            requestedTotalStr = "00" + totalRequestedTeacher;
        }else if(totalRequestedTeacher >= 10 && totalRequestedTeacher < 100){
            requestedTotalStr =  "0" + totalRequestedTeacher;
        }else if(totalRequestedTeacher >= 100 && totalRequestedTeacher <= 999){
            requestedTotalStr =  "" + totalRequestedTeacher;
        }else{
            return "";
        }
        Date date = vu.getDateRequest(teacherRequest.getTeacherDob());
        String dateStr = date.toString();
        String studentId = "STD" + year + requestedTotalStr + vu.convertDateToDDMMYYYY(teacherRequest.getTeacherDob(), "-") + vu.convertDateToDDMMYYYY(currDate, "/");
        return studentId;
    }

}
