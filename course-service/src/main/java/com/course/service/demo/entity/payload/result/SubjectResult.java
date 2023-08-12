package com.course.service.demo.entity.payload.result;

import com.course.service.demo.entity.model.Subject;

public class SubjectResult {

    private String subjectName;
    private String url;

    public SubjectResult(Subject subject){
        this.subjectName = subject.getSubjectName();
        this.url = "http://localhost:8082/v1/courses/subject/" + subject.getSubjectId();
    }

}
