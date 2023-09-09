package com.library.service.demo.controller;

import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.facade.BookFacade;
import com.module.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    BookFacade bookFacade;

    ResponseUtil responseUtil = ResponseUtil.getInstance();

    private static final String ADD_BOOK_ENDPOINT = "/add-book";
    private static final String GET_ALL_BOOKS_ENDPOINT = "";
    private static final String GET_BOOK_BY_BOOK_ID_ENDPOINT = "/{bookId}";
    private static final String DELETE_BOOK_BY_BOOK_ID_ENDPOINT = "/delete-book/{bookId}";

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @PostMapping(ADD_BOOK_ENDPOINT)
    public ResponseEntity<Map<String, Object>> addBook(BookRequest request){
        HttpStatus status = HttpStatus.CREATED;
        boolean success = true;
        String bookId = bookFacade.addNewBook(request);
        if(bookId.isEmpty()){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            success = false;
            responseMap.put("errorMessage", "request message false");
        }
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(), "bookId",
                bookId, success);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @GetMapping(GET_ALL_BOOKS_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getAllBooks(){
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        List<BookResult> bookResults = bookFacade.getAllBookResults();
        if(bookResults.isEmpty()){
            status = HttpStatus.NO_CONTENT;
        }
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(),
                "books", bookResults, success);
        return responseEntity;
    }

    @GetMapping(GET_BOOK_BY_BOOK_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getBookByBookId(@PathVariable String bookId){
        return responseEntity;
    }

    public ResponseEntity<Map<String, Object>> deleteBookByBookId(@PathVariable String bookId){
        return responseEntity;
    }

}
