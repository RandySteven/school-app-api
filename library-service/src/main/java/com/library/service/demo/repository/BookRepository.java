package com.library.service.demo.repository;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByBookId(String bookId);

//    @Query("SELECT b FROM books b WHERE b.book_status = ?1")
    List<Book> findBooksByBookStatus(BookStatus status);
}
