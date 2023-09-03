package com.library.service.demo.facade;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;

import java.util.List;

public interface BookFacade {

    String addNewBook(BookRequest bookRequest);
    Book getBookByBookId(String bookId);
    List<BookResult> getAllBookResults();
    BookResult getBookResultByBookId(String bookId);
    void deleteBookByBookId(String bookId);
    Book updateBookStatus(String bookId);
}
