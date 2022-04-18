package com.example.practiceMicroserviceCustomer.controller;

import com.example.practiceMicroserviceCustomer.service.CustomerServiceImpl;
import customer.Customer;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {


    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping(value = "/service/customers",method = RequestMethod.POST)
    public Customer save (@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @RequestMapping(value = "/service/customers/{id}",method = RequestMethod.GET)
    public Customer findById(@PathVariable(value = "id") int id) {
        return customerService.findById(id);
    }

    @RequestMapping(value = "/service/customers",method = RequestMethod.GET)
    public List<Customer> findAll(){
        return customerService.findAll();
    }

}
