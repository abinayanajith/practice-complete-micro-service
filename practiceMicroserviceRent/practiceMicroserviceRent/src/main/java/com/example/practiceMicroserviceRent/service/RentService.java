package com.example.practiceMicroserviceRent.service;


import com.example.practiceMicroserviceRent.model.DetailResponse;
import rent.Rent;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface RentService {

    Rent save(Rent rent);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}
