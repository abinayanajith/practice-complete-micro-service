package com.example.practiceMicroserviceCustomer.service;

import customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
