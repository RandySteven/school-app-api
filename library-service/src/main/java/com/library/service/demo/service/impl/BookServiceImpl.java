package com.library.service.demo.service.impl;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.repository.BookRepository;
import com.library.service.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book addNewBook(Book book) {
        book.setCreatedAt(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByBookId(String bookId) {
        return bookRepository.findBookByBookId(bookId);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBook(String bookId) {
        Book book = getBookByBookId(bookId);
        book.setDeletedAt(LocalDateTime.now());
        bookRepository.saveAndFlush(book);
    }
}
