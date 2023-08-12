package com.course.service.demo.entity.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Table(name="subjects")
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    private String subjectId;
    private String subjectName;
    private String subjectDetail;
    private int estimatedHour;
    private String courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDetail() {
        return subjectDetail;
    }

    public void setSubjectDetail(String subjectDetail) {
        this.subjectDetail = subjectDetail;
    }

    public int getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(int estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Subject(){}

    public Subject(Long id, String subjectId, String subjectName, String subjectDetail, int estimatedHour, String courseId) {
        this.id = id;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDetail = subjectDetail;
        this.estimatedHour = estimatedHour;
        this.courseId = courseId;
    }
}
