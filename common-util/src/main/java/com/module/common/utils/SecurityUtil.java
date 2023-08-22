package com.module.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class SecurityUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = -8967352047003901429L;

    public static SecurityUtil getInstance(){
        return new SecurityUtil();
    }

    private static final int SALT_RANGE  = 10;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

//    public Map<String, Boolean> studentRequestValidation(StudentRequest studentRequest){
//        Map<String, Boolean> requestValidation = new HashMap<String, Boolean>();
//        if(studentRequest.getStudentName().length() < 3 && studentRequest.getStudentName().length() > 32)
//            requestValidation.put("studentName", false);
//
//        if(studentRequest.getStudentPassword().length() < 8 && studentRequest.getStudentPassword().length() > 32)
//            requestValidation.put("studentPassword", false);
//
//        if(studentRequest.getStudentFatherName().length() < 3 && studentRequest.getStudentFatherName().length() > 32)
//            requestValidation.put("studentFatherName", false);
//
//        if(studentRequest.getStudentMotherName().length() < 3 && studentRequest.getStudentMotherName().length() > 32)
//            requestValidation.put("studentMotherName", false);
//
//        if(!studentRequest.getStudentEmail().contains("@") && !studentRequest.getStudentEmail().contains(".com"))
//            requestValidation.put("studentEmail", false);
//
//        for(Map.Entry<String, Boolean> request : requestValidation.entrySet()){
//            LOGGER.info("===== validation : " + request.getKey() + " : " + request.getValue());
//        }
//
//        return requestValidation;
//    }
//
//    public Map<String, Object> studentRequestUpdateValidation(Student student, StudentRequest studentRequest){
//        Map<String, Object> requestUpdateValidation = new HashMap<>();
//        String studentName = studentRequest.getStudentName() == null ? student.getStudentName() : studentRequest.getStudentName();
//        String studentEmail = studentRequest.getStudentEmail() == null ? student.getStudentEmail() : studentRequest.getStudentEmail();
//        String studentPassword = studentRequest.getStudentPassword() == null ? student.getStudentPassword() : studentRequest.getStudentPassword();
//        String studentFatherName = studentRequest.getStudentFatherName() == null ? student.getStudentFatherName() : studentRequest.getStudentFatherName();
//        String studentMotherName = studentRequest.getStudentMotherName() == null ? student.getStudentMotherName() : studentRequest.getStudentMotherName();
//        requestUpdateValidation.put("studentName", studentName);
//        requestUpdateValidation.put("studentEmail", studentEmail);
//        requestUpdateValidation.put("studentPassword", studentPassword);
//        requestUpdateValidation.put("studentFatherName", studentFatherName);
//        requestUpdateValidation.put("studentMother", studentMotherName);
//        return requestUpdateValidation;
//    }

    public String studentHashPassword(String input){
        byte []salt = new byte[SALT_RANGE];
        String result = "";
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte []hashedPassword = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < hashedPassword.length ; i++){
                sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16)).substring(1);
            }
            result = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
