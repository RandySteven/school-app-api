package com.library.service.demo.service;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.model.BookSQL;
import com.library.service.demo.enums.BookStatus;

import java.util.List;

public interface BookService {

    Book addNewBook(Book book);
    List<Book> getAllBooks();
    List<Book> getAllBooksByBookStatus(BookStatus status);
    Book getBookByBookId(String bookId);
    Book updateBook(Book book);
    void deleteBook(String bookId);
    void updateMultipleBooksStatus(List<Book> books);
    List<Book> getMultipleBooksFromBookIds(List<String> bookIds);

    BookSQL addNewBook(BookSQL bookSQL);
    List<BookSQL> getAllBookSQLs();
}
