package com.teacher.service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeacherServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("=== teacher service : http://localhost:8082");
		SpringApplication.run(TeacherServiceApplication.class, args);
	}

}
