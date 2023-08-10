package com.teacher.service.demo.enums;

public enum TeacherBachelorDegree {
    SPD("S.Pd"),
    SKOM("S.Kom");

    private final String degree;

    TeacherBachelorDegree(String degree){
        this.degree = degree;
    }

    public String getDegree(){
        return degree;
    }

}
