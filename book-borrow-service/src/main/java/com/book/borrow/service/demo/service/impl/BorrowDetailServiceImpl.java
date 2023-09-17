package com.book.borrow.service.demo.service.impl;

import com.book.borrow.service.demo.entity.model.BorrowDetail;
import com.book.borrow.service.demo.repository.BorrowDetailRepository;
import com.book.borrow.service.demo.service.BorrowDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowDetailServiceImpl implements BorrowDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowDetailServiceImpl.class);

    @Autowired
    BorrowDetailRepository borrowDetailRepository;

    @Override
    public void createBorrowDetail(String borrowId, List<String> bookIds) {
        List<BorrowDetail> borrowDetails = new ArrayList<>();
        LOGGER.info("== borrowId : " + borrowId);
        for (String bookId: bookIds) {
            LOGGER.info("== bookId : " + bookId);
            borrowDetails.add(new BorrowDetail(borrowId, bookId));
        }
        borrowDetailRepository.saveAll(borrowDetails);

    }

    @Override
    public List<BorrowDetail> getListBorrowDetailsByBorrowId(String borrowId) {
        return null;
    }
}
