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
     * }
     */

    private String userId;
    private List<String> bookIds;

    public BorrowRequest(){}

    public BorrowRequest(String userId, List<String> bookIds) {
        this.userId = userId;
        this.bookIds = bookIds;
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
}
