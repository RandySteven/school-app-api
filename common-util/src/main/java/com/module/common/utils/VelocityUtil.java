package com.module.common.utils;

import com.student.service.demo.entity.payloads.StudentRequest;
import com.teacher.service.demo.entity.payload.TeacherRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class VelocityUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = -164289867292336617L;

    public static VelocityUtil getInstance(){
        return new VelocityUtil();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(VelocityUtil.class);

    public Object p(String key){
        return null;
    }


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
        String year = getCurrentYear();
        String currDate = getCurrentDateTime();
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
        Date date = getDateRequest(studentRequest.getStudentDob());
        String dateStr = date.toString();
        String studentId = "STD" + year + requestedTotalStr + convertDateToDDMMYYYY(studentRequest.getStudentDob(), "-") + convertDateToDDMMYYYY(currDate, "/");
        return studentId;
    }

    public String generateAlphaNumeric(int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String toLower = alphabet.toLowerCase();
        String number = "0123456789";
        String alphaNumeric = alphabet + toLower + number;
        StringBuilder builder = new StringBuilder(length);
        for(int i = 0 ; i < length ; i++){
            char charIndex = alphabet.charAt((int)(Math.random() * alphaNumeric.length()));
            builder.append(charIndex);
        }
        return builder.toString();
    }

    /**
     * @getCurrentDateTime()
     * get current date time when u hit A.P.I
     * @return date
     */
    public String getCurrentDateTime(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String date = dateObj.format(formatter);
        return date;
    }

    /**
     *
     * @param dateRequest
     * @return
     */
    public Date getDateRequest(String dateRequest){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try{
            date = formatter.parse(dateRequest);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     *
     * @param date
     * @param separator (-, /)
     * @return
     */
    public String convertDateToDDMMYYYY(String date, String separator){
        return date.replace(separator,"");
    }

    /**
     * @getCurrentYear()
     * Get current year
     * @return
     */
    public String getCurrentYear(){
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public String generateTeacherId(TeacherRequest teacherRequest, int totalRequestedTeacher){
        String year = getCurrentYear();
        String currDate = getCurrentDateTime();
        String requestedTotalStr = "";
        if(totalRequestedTeacher < 10){
            requestedTotalStr = "00" + totalRequestedTeacher;
        }else if(totalRequestedTeacher >= 10 && totalRequestedTeacher < 100){
            requestedTotalStr =  "0" + totalRequestedTeacher;
        }else if(totalRequestedTeacher >= 100 && totalRequestedTeacher <= 999){
            requestedTotalStr =  "" + totalRequestedTeacher;
        }else{
            return "";
        }
        Date date = getDateRequest(teacherRequest.getTeacherDob());
        String dateStr = date.toString();
        String studentId = "STD" + year + requestedTotalStr + convertDateToDDMMYYYY(teacherRequest.getTeacherDob(), "-") + convertDateToDDMMYYYY(currDate, "/");
        return studentId;
    }
}
