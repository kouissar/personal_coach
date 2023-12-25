package com.funroom.coach.pa.repository;


import com.funroom.coach.pa.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    // You can define custom query methods here if needed
}
