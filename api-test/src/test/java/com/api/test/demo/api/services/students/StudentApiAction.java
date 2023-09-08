package com.api.test.demo.api.services.students;

import com.api.test.demo.api.action.CommonApiAction;
import org.apache.hc.core5.http.HttpResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StudentApiAction extends CommonApiAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentApiAction.class);

    private static final String STUDENT_PORT = "8081";

    private static final String REGISTER_STUDENT_ENDPOINT = "/v1/students/register-student";
    private static final String REGISTER_STUDENT_REQUEST_JSON_PATH = "";

    public HttpResponse registerStudent(Map<String, String> requestHeader, Map<String, Object> contextOverwrite)
        throws Exception {
        String requestBody = createRequestBody(REGISTER_STUDENT_REQUEST_JSON_PATH, contextOverwrite);
        LOGGER.info("=== request body : " + requestBody);
        HttpResponse response = post(REGISTER_STUDENT_ENDPOINT, requestHeader, requestBody);
        LOGGER.info("=== response : {}", new JSONObject(response.toString()));
        return response;
    }

}
