package com.library.service.demo.controller;

import com.library.service.demo.entity.payload.request.BookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private static final String ADD_BOOK_ENDPOINT = "/add-book";
    private static final String GET_ALL_BOOKS_ENDPOINT = "";
    private static final String GET_BOOK_BY_BOOK_ID_ENDPOINT = "/{bookId}";
    private static final String DELETE_BOOK_BY_BOOK_ID_ENDPOINT = "/delete-book/{bookId}";

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    @PostMapping(ADD_BOOK_ENDPOINT)
    public ResponseEntity<Map<String, Object>> addBook(BookRequest request){
        return responseEntity;
    }

    @GetMapping(GET_ALL_BOOKS_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getAllBooks(){
        return responseEntity;
    }

}
