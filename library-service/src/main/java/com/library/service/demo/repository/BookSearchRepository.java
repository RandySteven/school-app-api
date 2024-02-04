package com.library.service.demo.repository;

import com.library.service.demo.entity.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookSearchRepository extends ElasticsearchRepository<Book, String> {
}
