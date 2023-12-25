package com.funroom.coach.pa.service;



import com.funroom.coach.pa.model.Goal;
import com.funroom.coach.pa.repository.GoalRepository;
import com.funroom.coach.pa.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    @Autowired
    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}
