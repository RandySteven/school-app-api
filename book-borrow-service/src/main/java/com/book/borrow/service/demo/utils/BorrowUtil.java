package com.book.borrow.service.demo.utils;

import com.book.borrow.service.demo.entity.model.BorrowDetail;
import com.book.borrow.service.demo.entity.model.BorrowHeader;
import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.facade.BookFacade;
import com.library.service.demo.service.BookService;
import com.library.service.demo.utils.BookUtil;
import com.student.service.demo.facades.StudentFacade;
import com.student.service.demo.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BorrowUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowUtil.class);

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    BookUtil bookUtil = BookUtil.getInstance();

    public static BorrowUtil getInstance(){
        return new BorrowUtil();
    }

    public String generateBorrowId(){
        return "";
    }

    public BorrowHeader borrowRequestToBorrowHeader(BorrowRequest request){
        return new BorrowHeader();
    }

    public BorrowResult getBorrowResult(BorrowHeader header, List<String> bookIds){
        List<BookResult> bookResults = new ArrayList<>();
        for (String bookId: bookIds) {
            bookResults.add(bookUtil.bookToBookResult(bookService.getBookByBookId(bookId)));
        }
        return new BorrowResult(
                header.getBorrowId(),
                studentService.getStudentByStudentId(header.getStudentId()).getStudentName(),
                header.getBorrowedDate().toString(),
                header.getReturnDate().toString(),
                bookResults
        );
    }

}
