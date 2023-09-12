package com.book.borrow.service.demo.service;

import com.book.borrow.service.demo.entity.model.BorrowDetail;

import java.util.List;

public interface BorrowDetailService {

    void createBorrowDetail(String borrowId, List<String> bookIds);
    List<BorrowDetail> getListBorrowDetailsByBorrowId(String borrowId);

}
