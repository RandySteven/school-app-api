package com.module.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class VelocityUtil implements Serializable {

    @Autowired
    private Environment env;

    @Serial
    private static final long serialVersionUID = -164289867292336617L;

    public static VelocityUtil getInstance(){
        return new VelocityUtil();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(VelocityUtil.class);

    public Object p(String key){
        return env.getProperty(key);
    }

    public String generateAlphaNumeric(int length, boolean lower){
        if(lower){
            return generateAlphaNumericLowerAlphabet(length);
        }
        return generateAlphaNumeric(length);
    }

    public String generateAlphaNumeric(int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "0123456789";
        String alphaNumeric = alphabet + number;
        StringBuilder builder = new StringBuilder(length);
        for(int i = 0 ; i < length ; i++){
            char charIndex = alphaNumeric.charAt((int)(Math.random() * alphaNumeric.length()));
            builder.append(charIndex);
        }
        return builder.toString();
    }

    public String generateAlphaNumericLowerAlphabet(int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String toLower = alphabet.toLowerCase();
        String number = "0123456789";
        String alphaNumeric = alphabet + toLower + number;
        StringBuilder builder = new StringBuilder(length);
        for(int i = 0 ; i < length ; i++){
            char charIndex = alphaNumeric.charAt((int)(Math.random() * alphaNumeric.length()));
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

    /**
     * STD_RGS_d{8}.csv
     * @return student-registration-report.csv
     */
    public String generateStudentRegistrationReportCsv(){
        String fileName = "STD_RGS_" + generateDigitsNumber(8) + ".csv";
        return fileName;
    }
}
