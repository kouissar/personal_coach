package com.funroom.coach.pa.repository;


import com.funroom.coach.pa.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
    // Custom methods can be added here
}
