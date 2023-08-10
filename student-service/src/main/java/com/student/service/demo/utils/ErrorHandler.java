package com.student.service.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {

    public static ErrorHandler getInstance(){
        return new ErrorHandler();
    }

    private String generateStudentErrorMessage(Map<String, Boolean> requestValidation){
        if(requestValidation.get("studentName") != null && requestValidation.get("studentName").equals(false)){
            return "Student name's length must between 3 and 32";
        }

        if(requestValidation.get("studentEmail") != null && requestValidation.get("studentEmail").equals(false)){
            return "Student email's must contains @ and .com";
        }

        if(requestValidation.get("studentPassword") != null && requestValidation.get("studentPassword").equals(false)){
            return "Student password's length must between 8 and 16";
        }

        if(requestValidation.get("studentFatherName") != null && requestValidation.get("studentFatherName").equals(false)){
            return "Student's father name's length must between 3 and 32";
        }

        if(requestValidation.get("studentMotherName") != null && requestValidation.get("studentMotherName").equals(false)){
            return "Student's mother name's length must between 3 and 32";
        }

        return "";
    }

    public Map<String, String> studentRequestErrorHandlerMessage(Map<String, Boolean> requestValidation){
        Map<String, String> errorMessage = new HashMap<>();
        for(Map.Entry<String, Boolean> request : requestValidation.entrySet()){
            if(request.getValue().equals(false)){
                errorMessage.put(request.getKey(), generateStudentErrorMessage(requestValidation));
            }
        }
        return errorMessage;
    }

}
