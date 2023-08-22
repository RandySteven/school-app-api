package com.student.service.demo.facades;

import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.entity.payloads.result.StudentResult;
import com.student.service.demo.enums.StudentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface StudentFacade {

    String backupStudentFromStudentRequest(String id);
    CompletableFuture<String> registerNewStudent(StudentRequest studentRequest);
    Student updateStudentByStudentId(String studentId, StudentRequest studentRequest);
    List<StudentResult> getAllStudentsResults();
    void deleteStudentByStudentId(String studentId);
    StudentResult updateStudentStatus(String studentId, StudentStatus studentStatus);
    Student dropOutStudent(String studentId);
    Student getStudentByStudentId(String studentId);
}
