package com.book.borrow.service.demo.entity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "borrow_details")
@IdClass(BorrowBookId.class)
public class BorrowDetail {

    @Id
    private String borrowId;
    @Id
    private String bookId;

    public BorrowDetail(String borrowId, String bookId) {
        this.borrowId = borrowId;
        this.bookId = bookId;
    }

    public BorrowDetail(){}

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
