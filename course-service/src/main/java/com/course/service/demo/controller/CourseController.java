package com.course.service.demo.controller;

import com.course.service.demo.entity.dtos.CourseDTO;
import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.model.Subject;
import com.course.service.demo.entity.payload.request.CourseRequest;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.enums.Grade;
import com.course.service.demo.facade.CourseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    @Autowired
    CourseFacade courseFacade;

    /**
     * courses
     */
    private static final String ADD_COURSE = "/add-course";
    private static final String GET_ALL_COURSES = "";
    private static final String GET_COURSE_BY_COURSE_ID = "/{courseId}";

    /**
     * subjects
     */
    private static final String ADD_SUBJECT_WITH_COURSE_ID = "/{courseId}/add-subject";
    private static final String GET_SUBJECT_BY_SUBJECT_ID = "/subject/{subjectId}";

    ResponseEntity<Map<String, Object>> responseEntity;

    Map<String, Object> responseMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @PostMapping(ADD_COURSE)
    public ResponseEntity<Map<String, Object>> addCourse(@RequestBody CourseRequest request){
        responseMap = new HashMap<>();
        boolean success = true;
        String courseId = courseFacade.addCourse(request);
        responseMap.put("success", success);
        responseMap.put("responseCode", HttpStatus.CREATED.value());
        responseMap.put("responseMessage", HttpStatus.CREATED.getReasonPhrase());
        responseMap.put("courseId", courseId);
        responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
        return responseEntity;
    }

    @GetMapping(GET_ALL_COURSES)
    public ResponseEntity<Map<String, Object>> getAllCourses() {
        responseMap = new HashMap<>();
        boolean success = true;
        List<CourseResult> courseResults = courseFacade.getAllCourseResults();
        for (CourseResult course: courseResults) {
            LOGGER.info("=== courseResults : " + course.getUrl());
        }
        HttpStatus status = HttpStatus.OK;
//        if(!courseResults.isEmpty()){
//            success = true;
//            status = HttpStatus.OK;
//        }
        responseMap.put("success", success);
        responseMap.put("responseCode", status.value());
        responseMap.put("responseMessage", status.getReasonPhrase());
        responseMap.put("courseResults", courseResults);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @GetMapping(GET_COURSE_BY_COURSE_ID)
    public ResponseEntity<Map<String, Object>> getCourseByCourseId(@PathVariable String courseId){
        responseMap = new HashMap<>();
        LOGGER.info("=== courseId : " + courseId);
        CourseDTO courseDTO = courseFacade.getCourseByCourseId(courseId);
        courseDTO.getSubjects().forEach(subject -> {
            LOGGER.info("=== courseDTO : " + subject.getSubjectName());
        });
        boolean success = false;
        HttpStatus status = HttpStatus.NOT_FOUND;
        if(courseDTO!=null){
            success = true;
            status = HttpStatus.OK;
        }
        responseMap.put("success", success);
        responseMap.put("responseCode", status.value());
        responseMap.put("responseMessage", status.getReasonPhrase());
        responseMap.put("course", courseDTO);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }


    @PostMapping(ADD_SUBJECT_WITH_COURSE_ID)
    public ResponseEntity<Map<String, Object>> addSubjectByCourseId(@PathVariable String courseId,
                                                                    @RequestBody Subject subject){
        responseMap = new HashMap<>();
        String subjectId = courseFacade.addSubject(courseId, subject);
        boolean success = false;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(!subjectId.isEmpty()){
            success = true;
            status = HttpStatus.CREATED;
        }
        responseMap.put("success", success);
        responseMap.put("responseCode", status.value());
        responseMap.put("responseMessage", status.getReasonPhrase());
        responseMap.put("subjectId", subjectId);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    public ResponseEntity<Map<String, Object>> getSubjectBySubjectId(@PathVariable String subjectId){
        return responseEntity;
    }

}
