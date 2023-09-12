package com.book.borrow.service.demo.facade.impl;

import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.book.borrow.service.demo.facade.BorrowFacade;
import com.book.borrow.service.demo.service.BorrowDetailService;
import com.book.borrow.service.demo.service.BorrowHeaderService;
import com.book.borrow.service.demo.utils.BorrowUtil;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.facade.BookFacade;
import com.library.service.demo.service.BookService;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Service
public class BorrowFacadeImpl implements BorrowFacade, Serializable {

    @Serial
    private static final long serialVersionUID = -4435298641469674782L;

    @Autowired
    BorrowDetailService borrowDetailService;

    @Autowired
    BorrowHeaderService borrowHeaderService;

    @Autowired
    BookFacade bookFacade;

    BorrowUtil borrowUtil = BorrowUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowFacadeImpl.class);

    @Override
    public BorrowResult createBorrow(BorrowRequest request) {
        String borrowId = borrowHeaderService.createBorrowHeader(borrowUtil.borrowRequestToBorrowHeader(request));
        borrowDetailService.createBorrowDetail(borrowId, request.getBookIds());
        for (String bookId: request.getBookIds()) {
            bookFacade.updateBookStatus(bookId);
        }
        return borrowUtil.getBorrowResult(borrowHeaderService.getBorrowByBorrowId(borrowId), request.getBookIds());
    }

    @Override
    public List<BookResult> getAllBorrowResults() {
        return null;
    }

    @Override
    public BorrowResult getBorrowResultByBorrowId(String borrowId) {
        return null;
    }

    @Override
    public BorrowResult getBorrowResultByStudentId(String studentId) {
        return null;
    }
}
