//package com.api.gateway.demo.configs;
//
//import com.api.gateway.demo.enums.ServicePath;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.cloud.gateway.config.conditional.ConditionalOnEnabledPredicate;
//import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocatorBuilder routeLocatorBuilder(ConfigurableApplicationContext context){
//        return new RouteLocatorBuilder(context);
//    }
//
//    @Bean
//    @ConditionalOnEnabledPredicate
//    public PathRoutePredicateFactory pathRoutePredicateFactory() {
//        return new PathRoutePredicateFactory();
//    }
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(ServicePath.STUDENT_SERVICE.getServiceName(), r -> r
//                        .path(ServicePath.STUDENT_SERVICE.getPrefix())
//                        .uri(ServicePath.STUDENT_SERVICE.getUri()))
//                .route(ServicePath.COURSE_SERVICE.getServiceName(), r -> r
//                        .path(ServicePath.COURSE_SERVICE.getPrefix())
//                        .uri(ServicePath.COURSE_SERVICE.getUri()))
//                .build();
//    }
//
//}
