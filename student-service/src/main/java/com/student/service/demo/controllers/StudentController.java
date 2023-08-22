package com.student.service.demo.controllers;

import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.entity.payloads.result.StudentResult;
import com.student.service.demo.facades.StudentFacade;
import com.student.service.demo.services.StudentService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentFacade studentFacade;

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;
    
//    ResponseUtil ru = ResponseUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private static final String REGISTER_STUDENT_ENDPOINT = "/register-student";
    private static final String REGISTER_MULTIPLE_STUDENTS_ENDPOINT = "/register-multiple-students";
    private static final String GET_ALL_STUDENTS_ENDPOINT = "";
    private static final String GET_STUDENT_BY_STUDENT_ID_ENDPOINT = "/{studentId}";
    private static final String UPDATE_STUDENT_STATUS_BY_STUDENT_ID_ENDPOINT = "/update-student-status/{studentId}";
    private static final String DELETE_STUDENT_BY_STUDENT_ID_ENDPOINT = "/delete-student/{studentId}";
    private static final String STUDENT_BACKUP_ENDPOINT = "/backup-student/{requestId}";


    @PostMapping(REGISTER_STUDENT_ENDPOINT)
    public ResponseEntity<Map<String, Object>> registerStudent(@RequestBody StudentRequest studentRequest){
        LOGGER.info("=== endpoint : " + REGISTER_STUDENT_ENDPOINT);
        responseMap = new HashMap<>();
        CompletableFuture<String> studentIdFuture = studentFacade.registerNewStudent(studentRequest);
        String studentId;
        try{
            studentId = studentIdFuture.get();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        boolean success = true;
        HttpStatus status = HttpStatus.CREATED;
        Map<String, String> dataItem = new HashMap<>();
        dataItem.put("studentId", studentId);

        responseMap.put("status", status.value());
        responseMap.put("dataItem", dataItem);
        responseMap.put("success", success);

        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @GetMapping(GET_ALL_STUDENTS_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getAllStudents(){
        LOGGER.info("=== endpoint : " + GET_ALL_STUDENTS_ENDPOINT);
        responseMap = new HashMap<>();
        List<StudentResult> studentList = studentFacade.getAllStudentsResults();
        boolean success = true;
        HttpStatus status = HttpStatus.OK;

        responseMap.put("status", status.value());
        responseMap.put("students", studentList);
        responseMap.put("success", success);

        responseEntity = ResponseEntity.ok().body(responseMap);
        return responseEntity;
    }

    @PostMapping(STUDENT_BACKUP_ENDPOINT)
    public ResponseEntity<Map<String, Object>> backupStudentRequest(@PathVariable String requestId){
        responseMap = new HashMap<>();
        String studentId = studentFacade.backupStudentFromStudentRequest(requestId);
        boolean success = true;
        HttpStatus status = HttpStatus.CREATED;

        responseMap.put("status", status);
        responseMap.put("dataItem", studentId);
        responseMap.put("success", success);

        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @DeleteMapping(DELETE_STUDENT_BY_STUDENT_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> deleteStudentByStudentId(@PathVariable String studentId){
        return responseEntity;
    }

    @GetMapping(GET_STUDENT_BY_STUDENT_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getStudentByStudentId(@PathVariable String studentId){
        responseMap = new HashMap<>();
        Student student = studentFacade.getStudentByStudentId(studentId);
        boolean success = true;
        HttpStatus status = HttpStatus.OK;
        
        responseMap.put("status", status);
        responseMap.put("student", student);
        responseMap.put("success", success);
        
        responseEntity = ResponseEntity.ok().body(responseMap);
        return responseEntity;
    }

    @PatchMapping(UPDATE_STUDENT_STATUS_BY_STUDENT_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> updateStudentByStudentId(@PathVariable String studentId,
                                                                        @RequestBody StudentRequest studentRequest){
        Student student = studentFacade.updateStudentByStudentId(studentId, studentRequest);

        return responseEntity;
    }

}
