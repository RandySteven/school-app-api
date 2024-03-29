package com.library.service.demo.utils;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.model.BookSQL;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.module.common.utils.VelocityUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookUtil implements Serializable {

    @Serial
    private static final long serialVersionUID = -4150429801914392276L;

    VelocityUtil vu = VelocityUtil.getInstance();

    public static BookUtil getInstance(){
        return new BookUtil();
    }

    /**
     * BookId = BKS + Book.getName.substring(0, 3) + Book.getAuthor.substring(0, 3) + randomDigits(3)
     * @return
     */
    public String generateBookId(BookRequest request){
        String bookName = request.getBookTitle().replace(" ", "").toUpperCase().substring(0, 3);
        String bookAuthor = request.getAuthor().replace(" ", "").toUpperCase().substring(0, 3);
        String randomDigits = vu.generateDigitsNumber(3);
        return "BKS" + bookName + bookAuthor + randomDigits + vu.getDateDDMMYYYY();
    }

    public BookResult bookToBookResult(Book book){
        return new BookResult(book);
    }

    public List<BookResult> booksToBookResults(List<Book> books){
        List<BookResult> results = new ArrayList<>();
        books.forEach(book -> {
            if(book.getDeletedAt() == null){
                results.add(bookToBookResult(book));
            }
        });
        return results;
    }

    public Book bookSQLToBook(BookSQL bookSQL) {
        Book book = new Book();
        book.setBookId(bookSQL.getBookId());
        book.setBookTitle(bookSQL.getBookTitle());
        book.setBookStatus(bookSQL.getBookStatus());
        book.setAuthor(bookSQL.getAuthor());
        book.setBookDescription(bookSQL.getBookDescription());
        return book;
    }

    public List<Book> bookSQLsToBooks(List<BookSQL> bookSQLS){
        List<Book> books = new ArrayList<>();
        bookSQLS.forEach(bookSQL -> {
            books.add(bookSQLToBook(bookSQL));
        });
        return books;
    }

    public Book bookRequestToBook(BookRequest request){
        Book book = new Book();
        book.setBookTitle(request.getBookTitle());
        book.setBookDescription(request.getBookDescription());
        book.setAuthor(request.getAuthor());
        return book;
    }

}
