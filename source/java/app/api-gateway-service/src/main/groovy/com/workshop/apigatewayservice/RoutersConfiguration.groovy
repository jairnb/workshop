package com.workshop.apigatewayservice

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RoutersConfiguration {

    @Bean
    RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/companies")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:8085"))
                .build()
    }


}
