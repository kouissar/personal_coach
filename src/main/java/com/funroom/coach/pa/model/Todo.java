package com.funroom.coach.pa.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    // Constructors, getters, and setters
    // ...
}
