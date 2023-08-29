package com.api.gateway.demo.enums;

public enum ServicePath {

    STUDENT_SERVICE("student-service", "/v1/students/...", "http://localhost:8081"),
    COURSE_SERVICE("course-service", "/v1/courses/...", "http://localhost:8083");

    String serviceName;
    String prefix;
    String uri;

    ServicePath(String serviceName, String prefix, String uri){
        this.serviceName = serviceName;
        this.prefix = prefix;
        this.uri = uri;
    }

    public String getServiceName(){
        return serviceName;
    }

    public String getPrefix(){
        return prefix;
    }

    public String getUri(){
        return uri;
    }

}
