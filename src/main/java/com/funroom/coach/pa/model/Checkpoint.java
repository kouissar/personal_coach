package com.funroom.coach.pa.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Checkpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status; // e.g., 'Completed', 'Pending'

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    // Constructors, getters, and setters
    // ...
}
