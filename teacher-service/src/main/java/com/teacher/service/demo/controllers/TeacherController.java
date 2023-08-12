package com.teacher.service.demo.controllers;

import com.module.common.utils.ResponseUtil;
import com.module.common.utils.SecurityUtil;
import com.module.common.utils.VelocityUtil;
import com.teacher.service.demo.entity.model.Teacher;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import com.teacher.service.demo.entity.payload.TeacherResult;
import com.teacher.service.demo.facades.TeacherFacade;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/teachers")
public class TeacherController implements Serializable {

    @Serial
    private static final long serialVersionUID = -4198345790818900455L;
    @Autowired
    TeacherFacade teacherFacade;

    private static final String ADD_TEACHER_ENDPOINT = "/add-teacher";
    private static final String GET_ALL_TEACHERS_ENDPOINT = "";
    private static final String GET_TEACHER_BY_TEACHER_ID = "/{teacherId}";
    private static final String UPDATE_TEACHER_BY_TEACHER_ID = "/update-teacher/{teacherId}";
    private static final String DELETE_TEACHER_BY_TEACHER_ID = "/delete-teacher/{teacherId}";

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    VelocityUtil vu = VelocityUtil.getInstance();

    ResponseUtil ru = ResponseUtil.getInstance();

    SecurityUtil su = SecurityUtil.getInstance();

    @PostMapping(ADD_TEACHER_ENDPOINT)
    public ResponseEntity<Map<String, Object>> addTeacher(
            @RequestBody TeacherRequest teacherRequest){
        CompletableFuture<String> teacherIdFuture = teacherFacade.registerNewTeacher(teacherRequest);
        String teacherId;
        try{
            teacherId = teacherIdFuture.get();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        boolean success = true;
        HttpStatus status = HttpStatus.CREATED;
        Map<String, String> dataItem = new HashMap<>();
        dataItem.put("teacherId", teacherId);
        JSONObject response = ru.responseJSON(status, "dataItem", dataItem, success);
        responseEntity = ResponseEntity.status(status).body(response.toMap());
        return responseEntity;
    }

    @GetMapping(GET_ALL_TEACHERS_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getAllTeachers(){
        List<TeacherResult> teacherResults = teacherFacade.getAllTeachers();
        Map<String, Object> dataItem = new HashMap<>();
        boolean success = true;
        HttpStatus status = HttpStatus.OK;
        if(teacherResults.isEmpty()){
            dataItem.put("message", "Teachers data still empty");
        }
        dataItem.put("teachers", teacherResults);
        JSONObject response = ru.responseJSON(status, "dataItem", dataItem, success);
        responseEntity = ResponseEntity.ok().body(response.toMap());
        return responseEntity;
    }

    @GetMapping(GET_TEACHER_BY_TEACHER_ID)
    public ResponseEntity<Map<String, Object>> getTeacherByTeacherId(String teacherId){
        Teacher teacher = teacherFacade.getTeacherByTeacherId(teacherId);
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        Map<String, Object> dataItem = new HashMap<>();
        if(teacher == null){
            status = HttpStatus.NOT_FOUND;
            dataItem.put("message", "Teacher is not found");
        }
        dataItem.put("teacher", teacher);
        JSONObject response = ru.responseJSON(status, "dataItem", dataItem, success);
        responseEntity = ResponseEntity.ok().body(response.toMap());
        return responseEntity;
    }

}
