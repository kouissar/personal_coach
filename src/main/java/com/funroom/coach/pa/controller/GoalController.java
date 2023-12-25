package com.funroom.coach.pa.controller;



import com.funroom.coach.pa.model.Goal;
import com.funroom.coach.pa.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Goal goal = goalService.getGoalById(id);
        return goal != null ? ResponseEntity.ok(goal) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.saveGoal(goal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goalDetails) {
        Goal goal = goalService.getGoalById(id);
        if (goal == null) {
            return ResponseEntity.notFound().build();
        }
        goal.setTitle(goalDetails.getTitle());
        goal.setDescription(goalDetails.getDescription());
        goal.setType(goalDetails.getType());
        goal.setTerm(goalDetails.getTerm());
        final Goal updatedGoal = goalService.saveGoal(goal);
        return ResponseEntity.ok(updatedGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        Goal goal = goalService.getGoalById(id);
        if (goal == null) {
            return ResponseEntity.notFound().build();
        }
        goalService.deleteGoal(id);
        return ResponseEntity.ok().build();
    }
}
