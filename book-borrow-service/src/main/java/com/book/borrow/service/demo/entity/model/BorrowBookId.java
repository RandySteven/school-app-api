package com.book.borrow.service.demo.entity.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BorrowBookId implements Serializable {

    private static final long serialVersionUID = -8056070092935104114L;
    private String borrowId;
    private String bookId;

    public BorrowBookId(String borrowId, String bookId){
        this.borrowId = borrowId;
        this.bookId = bookId;
    }

    public BorrowBookId(){}

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
