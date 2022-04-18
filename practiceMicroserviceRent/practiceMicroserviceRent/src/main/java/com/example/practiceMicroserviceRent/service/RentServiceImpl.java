package com.example.practiceMicroserviceRent.service;

import com.example.practiceMicroserviceRent.hystrix.CommonHystrixCommand;
import com.example.practiceMicroserviceRent.hystrix.VehicleCommand;
import com.example.practiceMicroserviceRent.model.DetailResponse;
import com.example.practiceMicroserviceRent.repository.RentRepository;
import com.netflix.hystrix.HystrixCommand;
import customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rent.Rent;
import vehicle.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class RentServiceImpl implements RentService{

    @Autowired
    RentRepository rentRepository;

    @Autowired
    HystrixCommand.Setter setter;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent findById(int id) {

        Optional<Rent> rent = rentRepository.findById(id);
        if(rent.isPresent()){
            return rent.get();
        } else {
            return new Rent();
        }

    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException{

        Rent rent = this.findById(id);
        Customer customer = getCustomer(rent.getCustomerId());
        Vehicle vehicle = getVehicle(rent.getVehicleId());

        return new DetailResponse(rent, customer, vehicle);


    }

    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {

        CommonHystrixCommand<Customer> customerCommonHystrixCommand = new CommonHystrixCommand<Customer>("default",()->{
            return restTemplate.getForObject("http://localhost:8080/service/customers/"+customerId,Customer.class);
        },()->{
            return new Customer();
        });

        Future<Customer> customerFuture = customerCommonHystrixCommand.queue();
        return customerFuture.get();

       // return restTemplate.getForObject("http://localhost:8080/service/customers/"+customerId,Customer.class);
    }

    private Vehicle getVehicle(int vehicleId){

        VehicleCommand vehicleCommand = new VehicleCommand(restTemplate,vehicleId);
        return vehicleCommand.execute();
        //return restTemplate.getForObject("http://localhost:8080/service/vehicles/"+vehicleId,Vehicle.class);
    }
}
