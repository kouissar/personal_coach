package com.funroom.coach.pa.repository;


import com.funroom.coach.pa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Place for more methods
}
