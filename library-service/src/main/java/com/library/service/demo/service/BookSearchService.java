package com.library.service.demo.service;

import com.library.service.demo.entity.model.BookSearch;

import java.util.List;

public interface BookSearchService {

    BookSearch insertBookSearch(BookSearch bookSearch);
    List<BookSearch> getAllBooksSearch();

}
