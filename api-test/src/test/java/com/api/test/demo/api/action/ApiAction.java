package com.api.test.demo.api.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apiguardian.api.API;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public abstract class ApiAction {

    protected static final String API_HOST = "http://localhost:8181";

    protected static URL url;

    protected static CloseableHttpClient httpClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAction.class);

    ObjectMapper objectMapper = new ObjectMapper();

    public String apiServicePort(String port){
        return API_HOST + port;
    }

    private void init(){
        try{
            url = new URL(API_HOST);
            httpClient = HttpClients.createDefault();
        }catch (Exception e){
            LOGGER.info("=== error api action : " + e.getMessage());
        }
    }

    public HttpPost post(String endpoint) {
        init();
        String url = API_HOST + endpoint;
        HttpPost post = new HttpPost(url);
        return post;
    }

    public HttpGet get(String endpoint){
        init();
        String url = API_HOST + endpoint;
        HttpGet get = new HttpGet(url);
        return get;
    }

    protected String createRequestBody(String jsonPath, Map<String, Object> contextRewrite) throws
            FileNotFoundException, IOException {
        String requestBodyJson = new String(Files.readAllBytes(Paths.get(jsonPath)));
        Map<String, Object> dataMap = objectMapper.readValue(requestBodyJson, Map.class);
        for(Map.Entry<String, Object> context : contextRewrite.entrySet()) {
            dataMap.put(context.getKey(), context.getValue());
        }
        String updatedRequestBody = objectMapper.writeValueAsString(dataMap);
        return updatedRequestBody;
    }

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, String requestBody);

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, JSONObject requestBody);

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, Map<String, String> requestBody);

    public abstract HttpResponse get(String endpoint, Map<String, String> requestHeader);

}
