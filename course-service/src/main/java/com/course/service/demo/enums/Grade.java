package com.course.service.demo.enums;

public enum Grade {
    FIRST("01"),
    SECOND("02"),
    THIRD("03"),
    FOURTH("04"),
    FIFTH("05"),
    SIXTH("06"),
    SEVENTH("07"),
    EIGHTH("08"),
    NINTH("09"),
    TENTH("10"),
    ELEVENTH("11"),
    TWELFTH("12");

    private String number;

    Grade(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

}
