package com.book.borrow.service.demo.controller;

import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.book.borrow.service.demo.facade.BorrowFacade;
import com.module.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BorrowController {

    @Autowired
    BorrowFacade borrowFacade;

    ResponseUtil responseUtil = ResponseUtil.getInstance();

    Map<String, Object> responseMap;

    ResponseEntity<Map<String, Object>> responseEntity;

    private static final String CREATE_BORROW_ENDPOINT = "/create-borrow";

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowController.class);

    @PostMapping(CREATE_BORROW_ENDPOINT)
    public ResponseEntity<Map<String, Object>> createBorrow(@RequestBody BorrowRequest request){
        responseMap = new HashMap<>();
        BorrowResult borrowResult = borrowFacade.createBorrow(request);
        HttpStatus status = HttpStatus.CREATED;
        boolean success = true;
        responseMap = responseUtil.setResponseMap(status.value(), status.getReasonPhrase(), "borrowResult", borrowResult, success);
        responseEntity = ResponseEntity.status(status).body(responseMap);
        return responseEntity;
    }

}
