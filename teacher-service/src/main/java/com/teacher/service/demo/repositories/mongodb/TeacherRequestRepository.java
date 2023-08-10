package com.teacher.service.demo.repositories.mongodb;

import com.teacher.service.demo.entity.payload.TeacherRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRequestRepository extends MongoRepository<TeacherRequest, String> {
}
