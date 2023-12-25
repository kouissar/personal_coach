package com.funroom.coach.pa.repository;

import com.funroom.coach.pa.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    // Additional query methods can go here
}
