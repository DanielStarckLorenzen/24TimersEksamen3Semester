package com.example.kapsejlads24timers.controller;

import com.example.kapsejlads24timers.model.Boat;
import com.example.kapsejlads24timers.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BoatRESTController {

    @Autowired
    private BoatRepository boatRepository;

    @GetMapping("/boats")
    public List<Boat> getBoats(){
        return boatRepository.findAll();
    }

    @PostMapping("/boat")
    public void createBoat(@RequestBody Boat boat){
        boatRepository.save(boat);
    }

    @PostMapping("/removeBoat/{boatId}")
    public void removeBoat(@PathVariable int boatId){
        boatRepository.deleteById(boatId);
    }

    @GetMapping("/boat/{boatId}")
    public Boat getBoat(@PathVariable int boatId){
        return boatRepository.findById(boatId).get();
    }

}
