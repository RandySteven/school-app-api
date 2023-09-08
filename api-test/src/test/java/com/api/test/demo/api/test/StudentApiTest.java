package com.api.test.demo.api.test;

import com.api.test.demo.api.services.students.StudentApiAction;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentApiTest {

    StudentApiAction studentApiAction = new StudentApiAction();

    @Test
    public void studentRegistrationNormalScenario() throws Exception {
        Map<String, String> requestHeader = new HashMap<>();
        Map<String, Object> requestBody = new HashMap<>();

        requestHeader.put("Content-Type", "application/json");

        requestBody.put("studentName", "Randy Steven");
        requestBody.put("studentEmail", "randy.steven@school.id");
        requestBody.put("studentPassword", "Test_1234");
        HttpResponse response = studentApiAction.registerStudent(requestHeader, requestBody);
        Assertions.assertEquals(201, response.getCode());
    }

    public void studentRegistrationNameInvalidRequest() throws Exception {

    }

}
