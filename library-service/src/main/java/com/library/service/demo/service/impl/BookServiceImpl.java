package com.library.service.demo.service.impl;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.enums.BookStatus;
import com.library.service.demo.repository.BookRepository;
import com.library.service.demo.service.BookService;
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
    public List<Book> getAllBooksByBookStatus(BookStatus status) {
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
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBook(String bookId) {
        Book book = getBookByBookId(bookId);
        book.setDeletedAt(LocalDateTime.now());
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void updateMultipleBooksStatus(List<Book> books){
        books.forEach(book -> {
            book.setBookStatus(
                    book.getBookStatus() == BookStatus.AVAILABLE ?
                            BookStatus.BORROWED : BookStatus.AVAILABLE
            );
        });
        bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getMultipleBooksFromBookIds(List<String> bookIds){
        List<Book> books = new ArrayList<>();
        bookIds.forEach(bookId -> {
            books.add(getBookByBookId(bookId));
        });
        return books;
    }
}
