package com.book.borrow.service.demo.entity.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BorrowBookId implements Serializable {

    private String borrowId;
    private String bookId;

    public BorrowBookId(String borrowId, String bookId){
        this.borrowId = borrowId;
        this.bookId = bookId;
    }

    public BorrowBookId(){}
}
