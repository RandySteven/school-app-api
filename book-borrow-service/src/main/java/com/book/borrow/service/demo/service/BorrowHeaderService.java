package com.book.borrow.service.demo.service;

import com.book.borrow.service.demo.entity.model.BorrowHeader;
import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;

import java.util.List;

public interface BorrowHeaderService {

    BorrowHeader createBorrowHeader(BorrowHeader header);
    List<BorrowHeader> getAllBorrowHeader();
    BorrowHeader getBorrowByBorrowId(String borrowId);

}
