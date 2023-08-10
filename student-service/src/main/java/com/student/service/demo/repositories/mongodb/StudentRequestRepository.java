package com.student.service.demo.repositories.mongodb;

import com.student.service.demo.entity.payloads.StudentRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRequestRepository extends MongoRepository<StudentRequest, String> {
}
