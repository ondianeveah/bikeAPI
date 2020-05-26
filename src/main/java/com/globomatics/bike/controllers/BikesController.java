package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list () {
        return bikeRepository.findAll();
    }

    //When user submits registration, will be processed by this method
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Bike bike){
         bikeRepository.save(bike);
    }

    //get certain bike
    //will return certain bike based on the id
    @GetMapping("/{id}")
    public Bike get (@PathVariable ("id") long id){
        return bikeRepository.getOne(id);
    }

}
