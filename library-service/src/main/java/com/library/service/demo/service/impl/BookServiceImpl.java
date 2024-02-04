package com.library.service.demo.service.impl;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.model.BookSQL;
import com.library.service.demo.enums.BookStatus;
import com.library.service.demo.repository.BookRepository;
import com.library.service.demo.service.BookService;
import com.library.service.demo.utils.BookUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired(required = false)
    private final BookRepository bookRepository;

    BookUtil bookUtil;

    @Autowired(required = false)
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book addNewBook(Book book) {
        LOGGER.info("=== BookService : addNewBook()");
        book.setCreatedAt(LocalDateTime.now());
        return bookRepository.save((BookSQL) book);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("=== BookService : getAllBooks()");
        return bookUtil.bookSQLsToBooks(bookRepository.findAll());
    }

    @Override
    public List<Book> getAllBooksByBookStatus(BookStatus status) {
        LOGGER.info("=== BookService : getAllBooksByBookStatus()");
        List<Book> books = getAllBooks();
        List<Book> filteredBooks = new ArrayList<>();
        books.forEach(book -> {
            if(book.getBookStatus()==status)
                filteredBooks.add(book);
        });
        return filteredBooks;
    }

    @Override
    public Book getBookByBookId(String bookId) {
        return bookRepository.findBookByBookId(bookId);
    }

    @Override
    public Book updateBook(Book book) {
        return (Book)bookRepository.saveAndFlush((BookSQL) book);
    }

    @Override
    public void deleteBook(String bookId) {
        Book book = getBookByBookId(bookId);
        book.setDeletedAt(LocalDateTime.now());
        bookRepository.saveAndFlush((BookSQL) book);
    }

    @Override
    public void updateMultipleBooksStatus(List<Book> books){
        books.forEach(book -> {
            book.setBookStatus(
                    book.getBookStatus() == BookStatus.AVAILABLE ?
                            BookStatus.BORROWED : BookStatus.AVAILABLE
            );
        });
        bookRepository.saveAllAndFlush((List)books);
    }

    @Override
    public List<Book> getMultipleBooksFromBookIds(List<String> bookIds){
        List<Book> books = new ArrayList<>();
        bookIds.forEach(bookId -> {
            books.add(getBookByBookId(bookId));
        });
        return books;
    }

    @Override
    public BookSQL addNewBook(BookSQL bookSQL) {
        return null;
    }

    @Override
    public List<BookSQL> getAllBookSQLs() {
        return null;
    }
}
