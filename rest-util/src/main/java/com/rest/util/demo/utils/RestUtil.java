package com.rest.util.demo.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestUtil {

    RestTemplate restTemplate = new RestTemplate();

    public RestUtil(){}

    public static RestUtil getInstance(){
        return new RestUtil();
    }

    public Map<String, Object> getResponseBodyFromResponseEntity(String uri){
        return restTemplate.getForObject(uri, Map.class);
    }

    public Map<String, Object> getResponseBodyFromResponseEntity(String service, String endpoint){
        String uri = "http://localhost:8181/" + service + "/" + endpoint;
        Map<String, Object> responseBody = getResponseBodyFromResponseEntity(uri);
        return responseBody;
    }

    public Map<String, Object> getResponseBodyFromResponseEntity(String url, String service, String endpoint){
        String uri = url + "/" + service + "/" + endpoint;
        Map<String, Object> responseBody = getResponseBodyFromResponseEntity(uri);
        return responseBody;
    }

}
