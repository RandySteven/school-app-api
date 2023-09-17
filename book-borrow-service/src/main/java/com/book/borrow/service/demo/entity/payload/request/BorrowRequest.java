package com.book.borrow.service.demo.entity.payload.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowRequest {

    private String studentId;
    private List<String> bookIds;

    public BorrowRequest(){
        this.bookIds = new ArrayList<>();
    }

    public BorrowRequest(String studentId, List<String> bookIds) {
        this.studentId = studentId;
        this.bookIds = bookIds;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }
}
