package com.example.kapsejlads24timers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int points;

    @ManyToOne
    @JoinColumn(name = "boat_id")
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "regatta_id")
    private Regatta regatta;




}
