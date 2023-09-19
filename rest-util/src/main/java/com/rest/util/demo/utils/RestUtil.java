package com.rest.util.demo.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Component
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
        return getResponseBodyFromResponseEntity(uri);
    }

    public Map<String, Object> getResponseBodyFromResponseEntity(String url, String service, String endpoint){
        String uri = url + "/" + service + "/" + endpoint;
        return getResponseBodyFromResponseEntity(uri);
    }

    public Map<String, Object> getResponseBodyFromRequest(Object object, String uri){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(object, headers);
        return restTemplate.exchange(uri, HttpMethod.PATCH, entity, Map.class).getBody();
    }
}
