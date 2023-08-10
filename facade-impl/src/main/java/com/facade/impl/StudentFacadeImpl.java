package com.facade.impl;

import com.module.common.utils.SecurityUtil;
import com.module.common.utils.VelocityUtil;
import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.entity.payloads.result.StudentResult;
import com.student.service.demo.enums.StudentStatus;
import com.student.service.demo.facades.StudentFacade;
import com.student.service.demo.services.StudentRequestService;
import com.student.service.demo.services.StudentService;
import com.student.service.demo.utils.StudentUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    StudentRequestService studentRequestService;

    @Autowired
    StudentService studentService;

    VelocityUtil vu = VelocityUtil.getInstance();

    StudentUtil studentUtil = StudentUtil.getInstance();

    SecurityUtil securityUtil = SecurityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentFacadeImpl.class);

    @Override
    @Async
    public String backupStudentFromStudentRequest(String id) {
        List<StudentRequest> studentRequestList = studentRequestService.getAllStudentRequests();
        LOGGER.info("===== studentRequestList : " + new JSONObject(studentRequestList));
        StudentRequest studentRequest = studentUtil.getStudentRequestByStudentId(studentRequestList, id);
        int total = studentRequestService.getAllStudentRequestsSize();
        String studentId = vu.generateStudentId(studentRequest, total);
        Student student = studentUtil.studentRequestToStudentModel(studentRequest)
                .setStudentId(studentId);
        studentService.registerStudent(student);
        return student.getStudentId();
    }

    @Override
    @Async
    public CompletableFuture<String> registerNewStudent(StudentRequest studentRequest) {
        studentRequestService.saveStudentRequest(studentRequest);
        int total = studentRequestService.getAllStudentRequestsSize();
        LOGGER.info("==== requestId : " + studentRequest.getRequestId());
        LOGGER.info("==== request : "+ new JSONObject(studentRequest));
        String studentId = vu.generateStudentId(studentRequest, total);
        Student student = studentUtil.studentRequestToStudentModel(studentRequest)
                .setStudentId(studentId);
        studentService.registerStudent(student);
        LOGGER.info("===== request student model : " + new JSONObject(student));
        return CompletableFuture.completedFuture(student.getStudentId());
    }

    @Override
    public Student updateStudentByStudentId(String studentId, StudentRequest studentRequest) {
        Student student = studentService.getStudentByStudentId(studentId);
        Map<String, Object> requestUpdateValidation = securityUtil.studentRequestUpdateValidation(student, studentRequest);
        student
                .setStudentName(requestUpdateValidation.get("studentName").toString())
                .setStudentFatherName(requestUpdateValidation.get("studentFatherName").toString())
                .setStudentMotherName(requestUpdateValidation.get("studentMotherName").toString());
        studentService.updateStudent(student);
        return student;
    }

    @Override
    public List<StudentResult> getAllStudentsResults() {
        List<Student> students = studentService.getAllStudentList();
        List<StudentResult> studentResults = studentUtil.getAllActiveStudents(students);
        return studentResults;
    }

    @Override
    public void deleteStudentByStudentId(String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        studentService.deleteStudent(student);
    }

    @Override
    public StudentResult updateStudentStatus(String studentId, StudentStatus studentStatus) {
        Student student = studentService.getStudentByStudentId(studentId);
        student.setStudentStatus(studentStatus);
        studentService.updateStudent(student);
        StudentResult studentResult = studentUtil.studentModelToStudentResult(student);
        return studentResult;
    }

    @Override
    public Student dropOutStudent(String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        student.setStudentStatus(StudentStatus.DROPOUT);
        studentService.updateStudent(student);
        return student;
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        return student;
    }

}
