package com.student.service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("=== student service : http://localhost:8081");
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}
