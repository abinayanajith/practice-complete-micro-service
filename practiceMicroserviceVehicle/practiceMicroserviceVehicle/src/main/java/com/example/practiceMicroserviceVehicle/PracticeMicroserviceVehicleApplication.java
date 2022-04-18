package com.example.practiceMicroserviceVehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "vehicle")
@EnableEurekaClient
public class PracticeMicroserviceVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeMicroserviceVehicleApplication.class, args);
	}

}
