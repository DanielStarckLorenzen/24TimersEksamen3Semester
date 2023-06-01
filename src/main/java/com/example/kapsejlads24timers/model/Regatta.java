package com.example.kapsejlads24timers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import com.example.kapsejlads24timers.model.Participant;

import java.util.Set;

@Entity
@Data
public class Regatta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Size size;

    private boolean isFinished;

    @OneToMany(mappedBy = "regatta")
    @JsonBackReference
    private Set<Participant> participants;

}
