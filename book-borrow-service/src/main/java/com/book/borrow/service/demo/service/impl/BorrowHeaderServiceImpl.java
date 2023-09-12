package com.book.borrow.service.demo.service.impl;

import com.book.borrow.service.demo.entity.model.BorrowHeader;
import com.book.borrow.service.demo.enums.BorrowStatus;
import com.book.borrow.service.demo.repository.BorrowRepository;
import com.book.borrow.service.demo.service.BorrowHeaderService;
import com.book.borrow.service.demo.utils.BorrowUtil;
import com.module.common.utils.VelocityUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BorrowHeaderServiceImpl implements BorrowHeaderService {

    @Autowired
    BorrowRepository borrowRepository;

    VelocityUtil vu = VelocityUtil.getInstance();

    BorrowUtil bu = BorrowUtil.getInstance();

    @Override
    public String createBorrowHeader(BorrowHeader header) {
        String borrowId = bu.generateBorrowId();
        header.setBorrowId(borrowId);
        header.setBorrowStatus(BorrowStatus.BORROWING);
        header.setBorrowedDate(new Date(vu.getCurrentDateTime()));
        return borrowRepository.save(header).getBorrowId();
    }

    @Override
    public List<BorrowHeader> getAllBorrowHeader() {
        return null;
    }

    @Override
    public BorrowHeader getBorrowByBorrowId(String borrowId) {
        return null;
    }
}
