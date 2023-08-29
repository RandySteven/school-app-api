package com.api.test.demo.api.action;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apiguardian.api.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public abstract class ApiAction {

    protected static final String API_HOST = "http://localhost:";

    protected static URL url;

    protected static CloseableHttpClient httpClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAction.class);

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

}
