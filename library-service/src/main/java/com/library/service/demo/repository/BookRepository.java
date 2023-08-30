package com.library.service.demo.repository;

import com.library.service.demo.entity.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
