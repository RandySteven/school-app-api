package com.api.gateway.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiGatewayController {

    @GetMapping("")
    public Map<String, String> helloWorld(){
        return new HashMap<>(){{
            put("message", "Hello World");
            put("student-service", "http://localhost:8081/v1/students");
            put("course-service", "http://localhost:8083/v1/courses");
        }};
    }

    @GetMapping("test")
    public Map<String, Object> apiGatewayStart(){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("active", true);
        responseMap.put("message", "API Gateway already active");
        return responseMap;
    }

    @GetMapping("hello-world")
    public String helloWorldString(){
        return "Hello World";
    }

}
