package com.funroom.coach.pa.model;

//import javax.persistence.*;
//import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private GoalType type;

    @Enumerated(EnumType.STRING)
    private GoalTerm term;

    // Relationships
    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Checkpoint> checkpoints;

    // Constructors, getters, and setters
    // ...
}
