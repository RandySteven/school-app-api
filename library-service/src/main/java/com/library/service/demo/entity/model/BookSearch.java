package com.library.service.demo.entity.model;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="books")
public class BookSearch extends Book{

    @Id
    private String id;
}
