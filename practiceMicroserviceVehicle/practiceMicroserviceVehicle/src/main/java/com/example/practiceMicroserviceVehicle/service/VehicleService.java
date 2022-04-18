package com.example.practiceMicroserviceVehicle.service;

import vehicle.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle findById(int id);

    List<Vehicle> findAll();
}
