package com.api.gateway.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

//	@Autowired
//	RouteLocatorBuilder routeLocatorBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator routeBuilder(){
//		return routeLocatorBuilder.routes()
//				.route("student-service", r->r.path("/v1/students/**").uri("http://localhost:8081"))
//				.route("course-service", r->r.path("/v1/courses/**").uri("http://localhost:8083"))
//				.build();
//	}
}
