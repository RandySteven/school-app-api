package com.library.service.demo.facade.impl;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.facade.BookFacade;
import com.library.service.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookFacadeImpl implements BookFacade {

    @Autowired
    BookService bookService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFacadeImpl.class);

    @Override
    public String addNewBook(BookRequest bookRequest) {
        return null;
    }

    @Override
    public Book getBookByBookId(String bookId) {
        return null;
    }

    @Override
    public List<BookResult> getAllBookResults() {
        return null;
    }

    @Override
    public BookResult getBookResultByBookId(String bookId) {
        return null;
    }

    @Override
    public void deleteBookByBookId(String bookId) {

    }

    @Override
    public Book updateBookStatus(String bookId) {
        return null;
    }
}
