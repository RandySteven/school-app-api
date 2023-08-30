package com.api.test.demo.api.action;

import org.apache.hc.core5.http.HttpResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommonApiAction extends ApiAction{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonApiAction.class);

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, String requestBody) {
        return null;
    }

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, JSONObject requestBody) {
        return null;
    }

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, Map<String, String> requestBody) {
        return null;
    }

    @Override
    public HttpResponse get(String endpoint, Map<String, String> requestHeader) {
        return null;
    }
}
