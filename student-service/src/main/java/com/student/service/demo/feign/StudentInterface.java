package com.student.service.demo.feign;

import com.student.service.demo.entity.payloads.StudentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("STUDENT-SERVICE")
public interface StudentInterface {

    ResponseEntity<Map<String, Object>> registerStudent(@RequestBody StudentRequest studentRequest);

    ResponseEntity<Map<String, Object>> getAllStudents();
}
