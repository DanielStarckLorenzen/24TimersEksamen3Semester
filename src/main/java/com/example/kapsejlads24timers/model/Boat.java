package com.example.kapsejlads24timers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Size size;


    @OneToMany(mappedBy = "boat")
    @JsonBackReference
    private Set<Participant> participants;

}
