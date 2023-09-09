package com.book.borrow.service.demo.repository;

import com.book.borrow.service.demo.entity.model.BorrowHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowHeader, Long> {
}
