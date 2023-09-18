package com.library.service.demo.controller;

import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.request.BookRequest;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.enums.BookStatus;
import com.library.service.demo.facade.BookFacade;
import com.module.common.utils.ResponseUtil;
import org.json.JSONObject;
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
    private static final String UPDATE_BOOK_BY_BOOK_ID_ENDPOINT = "/update-book/{bookId}";
    private static final String UPDATE_BOOK_STATUS_BY_BOOK_ID_ENDPOINT = "/update-status/{bookId}";
    private static final String UPDATE_BOOK_STATUS_BY_MULTIPLE_REQUEST_BODIES_ENDPOINT = "/update-book-status";

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @PostMapping(ADD_BOOK_ENDPOINT)
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody BookRequest request){
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
    public ResponseEntity<Map<String, Object>> getAllBooks(@RequestParam(required = false) BookStatus bookStatus){
        LOGGER.info("======= Get All Books ========");
        LOGGER.info("==== Book Status : " + bookStatus);
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        List<BookResult> bookResults = bookFacade.getAllBookResults(bookStatus);
        if(bookResults == null){
            status = HttpStatus.NO_CONTENT;
        }
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(),
                "books", bookResults, success);
        LOGGER.info("== responseMap : " + new JSONObject(responseMap).toString());
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @GetMapping(GET_BOOK_BY_BOOK_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getBookByBookId(@PathVariable String bookId){
        responseMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        Book book = bookFacade.getBookByBookId(bookId);
        if(book==null){
            status = HttpStatus.NOT_FOUND;
            success = false;
        }
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(), "book", book, success);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @DeleteMapping(DELETE_BOOK_BY_BOOK_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> deleteBookByBookId(@PathVariable String bookId){
        return responseEntity;
    }

    @PatchMapping(UPDATE_BOOK_BY_BOOK_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> updateBookByBookId(@PathVariable String bookId, @RequestBody BookRequest bookRequest){
        responseMap = new HashMap<>();

        return responseEntity;
    }

    @PatchMapping(UPDATE_BOOK_STATUS_BY_BOOK_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> updateBookStatusByBookId(@PathVariable String bookId){
        responseMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        Book book = bookFacade.updateBookStatus(bookId);
        if(book == null){
            success = false;
            status = HttpStatus.NOT_FOUND;
        }
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(), "book", book, success);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

    @PatchMapping(UPDATE_BOOK_STATUS_BY_MULTIPLE_REQUEST_BODIES_ENDPOINT)
    public ResponseEntity<Map<String, Object>> updateBooksStatusByRequestBodies(@RequestBody List<String> bookIds){
        responseMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        boolean success = true;
        List<Book> books = bookFacade.updateMultipleBooksStatus(bookIds);
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(), "books", books, success);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

}
