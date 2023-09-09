package com.book.borrow.service.demo.facade.impl;

import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.book.borrow.service.demo.facade.BorrowFacade;
import com.book.borrow.service.demo.service.BorrowDetailService;
import com.book.borrow.service.demo.service.BorrowHeaderService;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowFacadeImpl.class);

    @Override
    public String createBorrow(BorrowRequest request) {
        /**
         * 1. request -> model header
         * 2. generate the borrowId
         * 3. update book status list of bookIds
         * 4. insert into book header service
         * 5. insert into book detail service
         */

        return null;
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
