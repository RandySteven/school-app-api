package com.student.service.demo.facades.impl;

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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentRequestService studentRequestService;

    private final StudentService studentService;

    @Autowired
    public StudentFacadeImpl(StudentRequestService studentRequestService, StudentService studentService){
        this.studentRequestService = studentRequestService;
        this.studentService = studentService;
    }

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
        String studentId = studentUtil.generateStudentId(studentRequest, total);
        Student student = studentUtil.studentRequestToStudentModel(studentRequest)
                .setStudentId(studentId);
        studentService.registerStudent(student);
        return student.getStudentId();
    }

    @Override
    @Async
    public Object registerNewStudent(StudentRequest studentRequest) {
        Map<String, Boolean> validationMap = studentUtil.studentRequestValidation(studentRequest);
        boolean isValid = vu.validationSuccessChecker(validationMap);
        if(isValid==false){
            return studentUtil.studentRequestGetValidationMessage(validationMap);
        }
        studentRequestService.saveStudentRequest(studentRequest);
        int total = studentRequestService.getAllStudentRequestsSize();
        LOGGER.info("==== requestId : " + studentRequest.getRequestId());
        LOGGER.info("==== request : "+ new JSONObject(studentRequest));
        String studentId = studentUtil.generateStudentId(studentRequest, total);
        Student student = studentUtil.studentRequestToStudentModel(studentRequest)
                .setStudentId(studentId)
                .setStudentPassword(securityUtil.studentHashPassword(studentRequest.getStudentPassword()));
        studentService.registerStudent(student);
        LOGGER.info("===== request student model : " + new JSONObject(student));
        return CompletableFuture.completedFuture(student.getStudentId());
    }

    @Override
    public Student updateStudentByStudentId(String studentId, StudentRequest studentRequest) {
        Student student = studentService.getStudentByStudentId(studentId);
        student
                .setStudentName(studentRequest.getStudentName() != null ? studentRequest.getStudentName() : student.getStudentName())
                .setStudentFatherName(studentRequest.getStudentFatherName() != null ? studentRequest.getStudentFatherName() : student.getStudentFatherName())
                .setStudentMotherName(studentRequest.getStudentMotherName() != null ? studentRequest.getStudentMotherName() : student.getStudentMotherName());
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
        studentUtil.validateStudentIsNotExist(student);
        studentUtil.validateStudentIsDeleted(student);
        studentService.deleteStudent(student);
    }

    @Override
    public StudentResult updateStudentStatus(String studentId, StudentStatus studentStatus) {
        Student student = studentService.getStudentByStudentId(studentId);
        studentUtil.validateStudentIsNotExist(student);
        studentUtil.validateStudentIsDeleted(student);
        student.setStudentStatus(studentStatus);
        studentService.updateStudent(student);
        StudentResult studentResult = studentUtil.studentModelToStudentResult(student);
        return studentResult;
    }

    @Override
    public Student dropOutStudent(String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        studentUtil.validateStudentIsNotExist(student);
        studentUtil.validateStudentIsDeleted(student);
        student.setStudentStatus(StudentStatus.DROPOUT);
        studentService.updateStudent(student);
        return student;
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        studentUtil.validateStudentIsNotExist(student);
        studentUtil.validateStudentIsDeleted(student);
        return student;
    }
}
