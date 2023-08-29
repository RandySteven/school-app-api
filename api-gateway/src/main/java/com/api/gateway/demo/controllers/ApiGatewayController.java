package com.api.gateway.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiGatewayController {

    @GetMapping("test")
    public Map<String, Object> apiGatewayStart(){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("active", true);
        responseMap.put("message", "API Gateway already active");
        return responseMap;
    }

}
