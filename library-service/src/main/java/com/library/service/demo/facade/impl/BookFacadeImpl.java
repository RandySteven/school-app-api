package com.library.service.demo.facade.impl;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.enums.BookStatus;
import com.library.service.demo.facade.BookFacade;
import com.library.service.demo.service.BookService;
import com.library.service.demo.utils.BookUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFacadeImpl implements BookFacade {

    @Autowired(required = false)
    private final BookService bookService;

    @Autowired(required = false)
    public BookFacadeImpl(BookService bookService){
        this.bookService = bookService;
    }

    BookUtil bookUtil = BookUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFacadeImpl.class);

    @Override
    public String addNewBook(BookRequest bookRequest) {
        String bookId = bookUtil.generateBookId(bookRequest);
        Book book = bookUtil.bookRequestToBook(bookRequest);
        book.setBookId(bookId);
        book.setBookStatus(BookStatus.AVAILABLE);
        bookService.addNewBook(book);
        return book.getBookId();
    }

    @Override
    public Book getBookByBookId(String bookId) {
        Book book = bookService.getBookByBookId(bookId);
        if(book.getDeletedAt()==null){
            return book;
        }
        return null;
    }

    @Override
    public List<BookResult> getAllBookResults(BookStatus status) {
        List<Book> books = bookService.getAllBooks();
        LOGGER.info("=== status : " + status);
        if(status != null) {
            books = bookService.getAllBooksByBookStatus(status);
        }
        if(books.isEmpty()){
            return null;
        }
        List<BookResult> bookResults = bookUtil.booksToBookResults(books);
        return bookResults;
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
        Book book = bookService.getBookByBookId(bookId);
        book.setBookStatus(book.getBookStatus() == BookStatus.AVAILABLE ? BookStatus.BORROWED : BookStatus.AVAILABLE);
        bookService.updateBook(book);
        return book;
    }

    @Override
    public List<Book> updateMultipleBooksStatus(List<String> bookIds){
        List<Book> books = bookService.getMultipleBooksFromBookIds(bookIds);
        bookService.updateMultipleBooksStatus(books);
        return books;
    }
}
