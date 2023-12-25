package com.funroom.coach.pa.service;


import com.funroom.coach.pa.model.Goal;

import java.util.List;

public interface GoalService {
    Goal saveGoal(Goal goal);
    Goal getGoalById(Long id);
    List<Goal> getAllGoals();
    void deleteGoal(Long id);
}
