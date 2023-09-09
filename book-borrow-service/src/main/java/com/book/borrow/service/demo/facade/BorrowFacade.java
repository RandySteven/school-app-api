package com.book.borrow.service.demo.facade;

import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.library.service.demo.entity.payload.result.BookResult;

import java.util.List;

public interface BorrowFacade {

    String createBorrow(BorrowRequest request);
    List<BookResult> getAllBorrowResults();
    BorrowResult getBorrowResultByBorrowId(String borrowId);
    BorrowResult getBorrowResultByStudentId(String studentId);

}
