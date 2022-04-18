package com.example.practiceMicroserviceRent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "rent")
@EnableEurekaClient
@EnableCircuitBreaker
public class PracticeMicroserviceRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeMicroserviceRentApplication.class, args);
	}

}
