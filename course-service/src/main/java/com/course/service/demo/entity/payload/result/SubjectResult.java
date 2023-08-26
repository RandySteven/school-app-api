package com.course.service.demo.entity.payload.result;

import com.course.service.demo.entity.model.Subject;

public class SubjectResult {

    private String subjectName;
    private String url;

    public SubjectResult(Subject subject){
        this.subjectName = subject.getSubjectName();
        this.url = "http://localhost:8082/v1/courses/subject/" + subject.getSubjectId();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
