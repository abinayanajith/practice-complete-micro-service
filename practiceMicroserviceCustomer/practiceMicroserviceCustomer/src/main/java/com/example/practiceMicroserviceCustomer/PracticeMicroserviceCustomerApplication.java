package com.example.practiceMicroserviceCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = "customer")
@EnableEurekaClient
public class PracticeMicroserviceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeMicroserviceCustomerApplication.class, args);
	}

}
