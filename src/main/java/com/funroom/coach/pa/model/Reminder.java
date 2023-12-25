package com.funroom.coach.pa.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reminderTime;
    private String message;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    // Constructors, getters, and setters
    // ...
}
