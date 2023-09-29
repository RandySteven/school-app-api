package com.book.borrow.service.demo.utils;

import com.module.common.utils.VelocityUtil;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class RestUtil {

    RestTemplate restTemplate = new RestTemplate();

    public RestUtil(){}

    VelocityUtil vu = VelocityUtil.getInstance();

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

//    public Map<String, Object> getResponseBodyFromRequest(Object object, String uri){
//        vu.debug(object);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Object> entity = new HttpEntity<>(object, headers);
//        vu.debug(entity);
//        return restTemplate.exchange(uri, HttpMethod.PATCH, entity, Map.class).getBody();
//    }

    public Map<String, Object> getResponseBodyFromRequest(List<String> requestList, String var, String uri){
//        http://localhost:8084/v1/books/update-book-status?bookIds=BKSBUKLAL731120923,BKSBUKLAL901170923
        uri += "?" + var + "=";
        for(int i = 0 ; i < requestList.size() ; i++){
            uri += requestList.get(i);
            if(i + 1 != requestList.size()){
                uri += ",";
            }
        }
        vu.debug("uri", uri);
        return getResponseBodyFromResponseEntity(uri);
    }
}