package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("theater-service", r -> r.path("/api/theaters/**")
                        .uri("http://localhost:1001"))
                .route("movie-service", r -> r.path("/api/movies/**")
                        .uri("http://localhost:1002"))
                .route("customer-service", r -> r.path("/api/customers/**")
                        .uri("http://localhost:1003"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://localhost:1004"))
                .build();
    } 	
}