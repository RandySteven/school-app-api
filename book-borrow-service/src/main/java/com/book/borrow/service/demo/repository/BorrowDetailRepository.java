package com.book.borrow.service.demo.repository;

import com.book.borrow.service.demo.entity.model.BorrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowDetailRepository extends JpaRepository<BorrowDetail, String> {

}
