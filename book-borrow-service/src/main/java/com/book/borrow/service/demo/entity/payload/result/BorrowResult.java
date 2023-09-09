package com.book.borrow.service.demo.entity.payload.result;

import com.library.service.demo.entity.payload.result.BookResult;

import java.util.List;

public class BorrowResult {

    private String borrowId;
    private String studentName;
    private String borrowedDate;
    private String returnDate;
    private List<BookResult> bookResults;

    public BorrowResult(){}

    public BorrowResult(String borrowId, String studentName, String borrowedDate, String returnDate, List<BookResult> bookResults) {
        this.borrowId = borrowId;
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public List<BookResult> getBookResults() {
        return bookResults;
    }

    public void setBookResults(List<BookResult> bookResults) {
        this.bookResults = bookResults;
    }
}
