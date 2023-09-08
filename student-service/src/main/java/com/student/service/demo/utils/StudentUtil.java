package com.student.service.demo.utils;

import com.module.common.utils.VelocityUtil;
import com.student.service.demo.entity.builders.StudentBuilder;
import com.student.service.demo.entity.models.Student;
import com.student.service.demo.entity.payloads.StudentRequest;
import com.student.service.demo.entity.payloads.result.StudentResult;
import com.student.service.demo.enums.StudentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class StudentUtil {

    public static StudentUtil getInstance(){
        return new StudentUtil();
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentUtil.class);

    private VelocityUtil vu = VelocityUtil.getInstance();

    /**
     * @StudentId
     * <h2>rules :</h2>
     * <ol>
     * <li>4 first digits is current year => 2023</li>
     * <li>3 digits is the increment of register student => 001 --> 999 : max 999 students</li>
     * <li>next 6 digits is student dd/mm/yy => 110401</li>
     * <li>6 is current date 290723 when admin input the data</li>
     * <li>STD2023001110401290723</li>
     * </ol>
     */
    public String generateStudentId(StudentRequest studentRequest, int totalRequestedStudent){
        String year = vu.getCurrentYear();
        String currDate = vu.getCurrentDateTime();
        String requestedTotalStr = "";
        if(totalRequestedStudent < 10){
            requestedTotalStr = "00" + totalRequestedStudent;
        }else if(totalRequestedStudent >= 10 && totalRequestedStudent < 100){
            requestedTotalStr =  "0" + totalRequestedStudent;
        }else if(totalRequestedStudent >= 100 && totalRequestedStudent <= 999){
            requestedTotalStr =  "" + totalRequestedStudent;
        }else{
            return "";
        }
        Date date = vu.getDateRequest(studentRequest.getStudentDob());
        String dateStr = date.toString();
        String studentId = "STD" + year + requestedTotalStr + vu.convertDateToDDMMYYYY(studentRequest.getStudentDob(), "-") + vu.convertDateToDDMMYYYY(currDate, "/");
        return studentId;
    }

    public Student studentRequestToStudentModel(StudentRequest studentRequest){
        return new StudentBuilder().build()
                .setStudentName(studentRequest.getStudentName())
                .setStudentEmail(studentRequest.getStudentEmail())
                .setStudentFatherName(studentRequest.getStudentFatherName())
                .setStudentStatus(StudentStatus.NORMAL)
                .setStudentDob(vu.getDateRequest(studentRequest.getStudentDob()))
                .setCreatedAt(LocalDateTime.now());
    }

    public StudentResult studentModelToStudentResult(Student student){
        return new StudentResult(student);
    }

    public List<StudentResult> getAllStudentResults(List<Student> students){
        List<StudentResult> studentResults = new ArrayList<>();
        for (Student student:
             students) {
            studentResults.add(studentModelToStudentResult(student));
        }
        return studentResults;
    }

    public List<StudentResult> getAllActiveStudents(List<Student> students){
        List<StudentResult> studentResults = new ArrayList<>();
        for (Student student:
             students) {
            if(student.getDeletedAt() != null || !student.getStudentStatus().equals(StudentStatus.DROPOUT)){
                studentResults.add(studentModelToStudentResult(student));
            }
        }
        return studentResults;
    }

    public StudentRequest getStudentRequestByStudentId(List<StudentRequest> studentRequestList, String requestId){
        int index = -1;
        LOGGER.info("======== requestId : " + requestId);
        boolean success = false;
        for(int i = 0 ; i < studentRequestList.size() ; i++){
//            LOGGER.info("==== studentRequest : " + new JSONObject(studentRequestList.get(i).getRequestId()));
            if(requestId.equals(studentRequestList.get(i).getRequestId())){
                index = i;
                success = true;
            }
        }

        if(success == true){
            return studentRequestList.get(index);
        }

        return null;
    }

    public Map<String, Boolean> studentRequestValidation(StudentRequest request) {
        Map<String, Boolean> validationMap = new HashMap<>();

        if(vu.stringLengthValidation(request.getStudentName(), 3, 32) == false){
            validationMap.put("studentName", false);
        }

        if(vu.stringLengthValidation(request.getStudentPassword(), 8, 32) == false){
            validationMap.put("studentPassword", false);
        }

        if(vu.stringLengthValidation(request.getStudentFatherName(), 3, 32) == false){
            validationMap.put("studentFatherName", false);
        }

        if(vu.stringLengthValidation(request.getStudentMotherName(), 3, 32) == false){
            validationMap.put("studentMotherName", false);
        }
        return validationMap;
    }

    public Map<String, String> studentRequestGetValidationMessage(Map<String, Boolean> validationMap){
        Map<String, String> requestMessage = new HashMap<>();
        for (Map.Entry<String, Boolean> map: validationMap.entrySet()) {
            if(!map.getValue()){
                requestMessage.put(map.getKey(), "Invalid request value at field : " + map.getKey());
            }
        }
        return requestMessage;
    }

}
