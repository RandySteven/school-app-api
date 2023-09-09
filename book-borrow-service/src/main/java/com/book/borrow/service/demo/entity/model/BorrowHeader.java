package com.book.borrow.service.demo.entity.model;

import com.book.borrow.service.demo.enums.BorrowStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Table(name = "borrow_headers")
@Entity
public class BorrowHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    private String borrowId;
    private String studentId;
    private BorrowStatus borrowStatus;
    private Date borrowedDate;
    private Date returnDate;

    public BorrowHeader(){}

    public BorrowHeader(Long id, String borrowId, String studentId, BorrowStatus borrowStatus, Date borrowedDate, Date returnDate) {
        this.id = id;
        this.borrowId = borrowId;
        this.studentId = studentId;
        this.borrowStatus = borrowStatus;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
