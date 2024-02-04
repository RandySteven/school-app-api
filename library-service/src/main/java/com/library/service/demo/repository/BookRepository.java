package com.library.service.demo.repository;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.model.BookSQL;
import com.library.service.demo.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookSQL, Long> {
    Book findBookByBookId(String bookId);

//    @Query("SELECT b FROM books b WHERE b.book_status = ?1")
    List<Book> findBooksByBookStatus(BookStatus status);
}
