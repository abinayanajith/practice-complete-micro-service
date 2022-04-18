package com.example.practiceMicroserviceRent.controller;

import com.example.practiceMicroserviceRent.model.Response;
import com.example.practiceMicroserviceRent.model.SimpleResponse;
import com.example.practiceMicroserviceRent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rent.Rent;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/service/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent){

        return rentService.save(rent);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id, @RequestParam(required = false) String type) throws ExecutionException, InterruptedException{
            if(type==null){
                return new SimpleResponse(rentService.findById(id));
            } else {
                return rentService.findDetailResponse(id);
            }


    }

    @GetMapping
    public List<Rent> findAll(){
        return rentService.findAll();
    }
}
