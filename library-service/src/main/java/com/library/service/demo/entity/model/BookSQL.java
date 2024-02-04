package com.library.service.demo.entity.model;

import com.library.service.demo.enums.BookStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Table(name="books")
@Entity
public class BookSQL extends Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    public BookSQL(Long id) {
        this.id = id;
    }

    public BookSQL(String bookId, String bookTitle, String bookDescription, String author, BookStatus bookStatus, LocalDateTime createdAt, LocalDateTime deletedAt, Long id) {
        super(bookId, bookTitle, bookDescription, author, bookStatus, createdAt, deletedAt);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
