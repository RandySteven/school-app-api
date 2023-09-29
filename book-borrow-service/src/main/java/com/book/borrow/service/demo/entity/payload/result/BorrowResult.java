package com.book.borrow.service.demo.entity.payload.result;

import com.library.service.demo.entity.payload.result.BookResult;

import java.util.List;

public class BorrowResult {

    private String borrowId;
    private Object student;
    private String borrowedDate;
    private String returnDate;
    private Object bookResults;

    public BorrowResult(){}

    public BorrowResult(String borrowId, Object student, String borrowedDate, String returnDate, Object bookResults) {
        this.borrowId = borrowId;
        this.student = student;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.bookResults = bookResults;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Object getStudent() {
        return student;
    }

    public void setStudent(Object student) {
        this.student = student;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Object getBookResults() {
        return bookResults;
    }

    public void setBookResults(Object bookResults) {
        this.bookResults = bookResults;
    }
}
