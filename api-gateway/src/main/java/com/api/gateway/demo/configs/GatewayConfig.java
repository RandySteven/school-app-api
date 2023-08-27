package com.api.gateway.demo.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("student-service", r -> r
                        .path("/v1/students/**")
                        .uri("http://localhost:8081"))
                .route("course-service", r -> r
                        .path("/v1/courses/**")
                        .uri("http://localhost:8083"))
                .build();
    }

}
