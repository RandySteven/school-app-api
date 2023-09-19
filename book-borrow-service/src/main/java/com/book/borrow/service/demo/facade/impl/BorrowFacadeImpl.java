package com.book.borrow.service.demo.facade.impl;

import com.book.borrow.service.demo.entity.model.BorrowHeader;
import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.book.borrow.service.demo.facade.BorrowFacade;
import com.book.borrow.service.demo.service.BorrowDetailService;
import com.book.borrow.service.demo.service.BorrowHeaderService;
import com.book.borrow.service.demo.utils.BorrowUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.facade.BookFacade;
import com.library.service.demo.service.BookService;
import com.module.common.utils.VelocityUtil;
import com.netflix.discovery.converters.Auto;
import com.rest.util.demo.utils.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowFacadeImpl implements BorrowFacade {

    @Autowired
    BorrowDetailService borrowDetailService;

    @Autowired
    BorrowHeaderService borrowHeaderService;

    @Autowired
    BookFacade bookFacade;

    BorrowUtil borrowUtil = BorrowUtil.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    RestUtil restUtil = RestUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowFacadeImpl.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BorrowResult createBorrow(BorrowRequest request) {
        BorrowHeader header = new BorrowHeader();
        vu.debug(request.getStudentId());
        vu.debug(request.getBookIds());
        header.setStudentId(request.getStudentId());
        String borrowId = borrowHeaderService.createBorrowHeader(header);
        borrowDetailService.createBorrowDetail(borrowId, request.getBookIds());
        for (String bookId: request.getBookIds()) {
            restUtil.getResponseBodyFromResponseEntity("http://localhost:8181", "v1/books", "/update-book-status");
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
