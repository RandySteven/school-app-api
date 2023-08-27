package com.main.application.demo;

import com.course.service.demo.CourseServiceApplication;
import com.student.service.demo.StudentServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		LOGGER.info("=== === === : Run Main Application : === === ===");
		SpringApplication.run(MainApplication.class, args);
		LOGGER.info("=== === === : Start to Run Student Application : === === ===");
		SpringApplication.run(StudentServiceApplication.class, args);
		LOGGER.info("=== === === : Start to Run Course Application : === === ===");
		SpringApplication.run(CourseServiceApplication.class, args);
	}

}
