package com.example.kapsejlads24timers.controller;

import com.example.kapsejlads24timers.model.Regatta;
import com.example.kapsejlads24timers.repository.RegattaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RegattaRESTController {

    @Autowired
    private RegattaRepository regattaRepository;

    @GetMapping("/regattas")
    public List<Regatta> getRegattas(){
        System.out.println("Getting regattas");
        return regattaRepository.findAll();
    }

    @PostMapping("/regatta")
    public Regatta createRegatta(@RequestBody Regatta regatta){
        return regattaRepository.save(regatta);
    }

    @PostMapping("/removeRegatta/{regattaId}")
    public void removeRegatta(@PathVariable int regattaId){
        regattaRepository.deleteById(regattaId);
    }


}
