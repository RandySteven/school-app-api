package com.module.common.utils;

import com.course.service.demo.entity.model.Course;
import com.course.service.demo.enums.Grade;
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

    public String generateDigitsNumber(int len){
        String number = "0123456789";
        StringBuilder builder = new StringBuilder(len);
        for(int i = 0 ; i < len ; i++){
            char charIndex = number.charAt((int)(Math.random() * number.length()));
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

    /**
     *
     * @param course
     * courseId = CRS + (first 3 chars from course name) + (grade / level [09|10|11|12]) + randomDigits(6)
     * sample :
     * courseId = CRSMAT10123456
     * @return
     */
    public String generateCourseId(Course course, Grade grade){
        String firstThreeChars = course.getCourseName().substring(0, 3);
        String courseId = "CRS" + firstThreeChars + grade.getNumber() + generateDigitsNumber(6);
        return courseId;
    }

}
