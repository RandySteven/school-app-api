package com.library.service.demo.facade;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.enums.BookStatus;

import java.util.List;

public interface BookFacade {

    String addNewBook(BookRequest bookRequest);
    Book getBookByBookId(String bookId);
    List<BookResult> getAllBookResults(BookStatus status);
    BookResult getBookResultByBookId(String bookId);
    void deleteBookByBookId(String bookId);
    Book updateBookStatus(String bookId);
    List<Book> updateMultipleBooksStatus(List<String> bookIds);
}
