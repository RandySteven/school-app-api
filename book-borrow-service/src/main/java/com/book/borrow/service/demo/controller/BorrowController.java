package com.book.borrow.service.demo.controller;

import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.facade.BorrowFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BorrowController {

    @Autowired
    BorrowFacade borrowFacade;

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    private static final String CREATE_BORROW_ENDPOINT = "/create-borrow";

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowController.class);

    public ResponseEntity<Map<String, Object>> createBorrow(BorrowRequest request){
        return responseEntity;
    }

}
