package com.book.borrow.service.demo.utils;

import com.book.borrow.service.demo.entity.model.BorrowDetail;
import com.book.borrow.service.demo.entity.model.BorrowHeader;
import com.book.borrow.service.demo.entity.payload.request.BorrowRequest;
import com.book.borrow.service.demo.entity.payload.result.BorrowResult;
import com.book.borrow.service.demo.enums.BorrowStatus;
import com.library.service.demo.entity.model.Book;
import com.library.service.demo.entity.payload.result.BookResult;
import com.library.service.demo.utils.BookUtil;
import com.module.common.utils.VelocityUtil;
import com.student.service.demo.entity.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BorrowUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowUtil.class);

    BookUtil bookUtil = BookUtil.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    RestUtil restUtil = RestUtil.getInstance();

    public static BorrowUtil getInstance(){
        return new BorrowUtil();
    }

    public BorrowHeader borrowRequestToBorrowHeader(BorrowRequest request){
        BorrowHeader header = new BorrowHeader();
        header.setStudentId(request.getStudentId());
        return header;
    }

    public BorrowResult getBorrowResult(BorrowHeader header, List<String> bookIds, Object books){
        List<BookResult> bookResults = new ArrayList<>();
        Map<String, Object> studentResult = restUtil.getResponseBodyFromResponseEntity("http://localhost:8081/v1/students/"+header.getStudentId());
        Student student = null;
        if(studentResult.get("student") instanceof Student){
            student = (Student) studentResult.get("student");
        }
        return new BorrowResult(
                header.getBorrowId(),
                student.getStudentName(),
                header.getBorrowedDate().toString(),
                "",
                books
        );
    }

    public String generateBorrowId(){
        String randomDigits = vu.generateAlphaNumeric(16, false);
        return "BRW" + randomDigits;
    }

}
