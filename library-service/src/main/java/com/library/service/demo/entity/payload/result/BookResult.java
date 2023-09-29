package com.library.service.demo.entity.payload.result;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.enums.BookStatus;

public class BookResult {

    private String bookTitle;
    private String author;
    private String url;
    private BookStatus bookStatus;

    public BookResult(Book book){
        this.bookTitle = book.getBookTitle();
        this.author = book.getAuthor();
        this.bookStatus = book.getBookStatus();
        this.url = "http://localhost:8084/v1/books/" + book.getBookId();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BookStatus getBookStatus(){
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus){
        this.bookStatus = bookStatus;
    }
}
