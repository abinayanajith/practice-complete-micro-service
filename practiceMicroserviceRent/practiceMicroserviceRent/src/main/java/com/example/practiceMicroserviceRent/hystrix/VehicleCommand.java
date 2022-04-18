package com.example.practiceMicroserviceRent.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import vehicle.Vehicle;

public class VehicleCommand extends HystrixCommand<Vehicle> {

    //@Autowired ,why not autowire
    RestTemplate restTemplate;

    int vehicleId;

    public VehicleCommand(RestTemplate restTemplate, int id){

        super(HystrixCommandGroupKey.Factory.asKey("default"));

        this.restTemplate= restTemplate;
        this.vehicleId= id;
    }



    @Override
    protected Vehicle run() throws Exception {
        return restTemplate.getForObject("http://localhost:8080/service/vehicles/"+vehicleId,Vehicle.class);
    }

    @Override
    protected Vehicle getFallback() {
        return new Vehicle();
    }
}
