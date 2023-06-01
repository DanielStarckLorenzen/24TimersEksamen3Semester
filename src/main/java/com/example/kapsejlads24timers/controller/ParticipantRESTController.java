package com.example.kapsejlads24timers.controller;

import com.example.kapsejlads24timers.model.Participant;
import com.example.kapsejlads24timers.repository.BoatRepository;
import com.example.kapsejlads24timers.repository.ParticipantRepository;
import com.example.kapsejlads24timers.repository.RegattaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ParticipantRESTController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private RegattaRepository regattaRepository;

    @PostMapping("/participant/{boatId}/{regattaId}")
    public void createParticipant(@RequestBody Participant participant, @PathVariable int boatId, @PathVariable int regattaId){
        System.out.println("Boat ID: " + boatId);
        System.out.println("Regatta ID: " + regattaId);
        participant.setBoat(boatRepository.findById(boatId).get());
        participant.setRegatta(regattaRepository.findById(regattaId).get());
        participantRepository.save(participant);
    }

    @GetMapping("/participants")
    public List<Participant> getParticipants(){
        return participantRepository.findAll();
    }

    @PostMapping("/removeParticipant/{participantId}")
    public void removeParticipant(@PathVariable int participantId){
        participantRepository.deleteById(participantId);
    }

    @PostMapping("/updateParticipant/{participantId}")
    public void updateParticipant(@PathVariable int participantId, @RequestBody Participant participant){
        System.out.println("Participant ID: " + participantId);
        Participant participantToUpdate = participantRepository.findById(participantId).get();
        participantToUpdate.setBoat(participantToUpdate.getBoat());
        participantToUpdate.setRegatta(participantToUpdate.getRegatta());
        participantToUpdate.setPoints(participant.getPoints());
        participantRepository.save(participantToUpdate);
    }

}
