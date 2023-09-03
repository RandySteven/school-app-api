package com.library.service.demo.service;

import com.library.service.demo.entity.model.Book;

import java.util.List;

public interface BookService {

    Book addNewBook(Book book);
    List<Book> getAllBooks();
    Book getBookByBookId(String bookId);
    Book updateBook(Book book);
    void deleteBook(String bookId);

}
