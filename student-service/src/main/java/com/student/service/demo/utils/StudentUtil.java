package com.student.service.demo.utils;

import com.module.common.utils.VelocityUtil;
import com.student.service.demo.entity.builders.StudentBuilder;
import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.entity.payloads.result.StudentResult;
import com.student.service.demo.enums.StudentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentUtil {

    public static StudentUtil getInstance(){
        return new StudentUtil();
    }

    VelocityUtil vu = VelocityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentUtil.class);

    public Student studentRequestToStudentModel(StudentRequest studentRequest){
        return new StudentBuilder().build()
                .setStudentName(studentRequest.getStudentName())
                .setStudentEmail(studentRequest.getStudentEmail())
                .setStudentFatherName(studentRequest.getStudentFatherName())
                .setStudentStatus(StudentStatus.NORMAL)
                .setStudentDob(vu.getDateRequest(studentRequest.getStudentDob()))
                .setCreatedAt(LocalDateTime.now());
    }

    public StudentResult studentModelToStudentResult(Student student){
        return new StudentResult(student);
    }

    public List<StudentResult> getAllStudentResults(List<Student> students){
        List<StudentResult> studentResults = new ArrayList<>();
        for (Student student:
             students) {
            studentResults.add(studentModelToStudentResult(student));
        }
        return studentResults;
    }

    public List<StudentResult> getAllActiveStudents(List<Student> students){
        List<StudentResult> studentResults = new ArrayList<>();
        for (Student student:
             students) {
            if(student.getDeletedAt() != null || !student.getStudentStatus().equals(StudentStatus.DROPOUT)){
                studentResults.add(studentModelToStudentResult(student));
            }
        }
        return studentResults;
    }

    public StudentRequest getStudentRequestByStudentId(List<StudentRequest> studentRequestList, String requestId){
        int index = -1;
        LOGGER.info("======== requestId : " + requestId);
        boolean success = false;
        for(int i = 0 ; i < studentRequestList.size() ; i++){
//            LOGGER.info("==== studentRequest : " + new JSONObject(studentRequestList.get(i).getRequestId()));
            if(requestId.equals(studentRequestList.get(i).getRequestId())){
                index = i;
                success = true;
            }
        }

        if(success == true){
            return studentRequestList.get(index);
        }

        return null;
    }

}
