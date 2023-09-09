package com.book.borrow.service.demo.entity.payload.request;

import java.util.Date;
import java.util.List;

public class BorrowRequest {

    /**
     * {
     *     "userId": "",
     *     "books": [
     *          "bookId": "",
     *          "bookId": "",
     *     ],
     *     "borrowedDate": ""
     * }
     */

    private String userId;
    private List<String> bookIds;
    private Date borrowedDate;

    public BorrowRequest(){}

    public BorrowRequest(String userId, List<String> bookIds, Date borrowedDate) {
        this.userId = userId;
        this.bookIds = bookIds;
        this.borrowedDate = borrowedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}
