package com.example.practiceMicroserviceVehicle.controller;

import com.example.practiceMicroserviceVehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vehicle.Vehicle;

import java.util.List;

@RestController
@RequestMapping(value = "/service/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle){
        return vehicleService.save(vehicle);
    }

    @GetMapping(value = "/{id}")
    public Vehicle findById(@PathVariable int id){

        return vehicleService.findById(id);
    }

    @GetMapping
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }


}
