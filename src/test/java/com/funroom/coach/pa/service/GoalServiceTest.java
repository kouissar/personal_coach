package com.funroom.coach.pa.service;


import com.funroom.coach.pa.model.Goal;
import com.funroom.coach.pa.repository.GoalRepository;
import com.funroom.coach.pa.service.GoalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalServiceTest {

    @Mock
    private GoalRepository goalRepository;

    @InjectMocks
    private GoalServiceImpl goalService;

    private Goal goal;

    @BeforeEach
    void setUp() {
        goal = new Goal();
        goal.setId(1L);
        goal.setTitle("Test Goal");
        // Set other properties
    }

    @Test
    void shouldSaveGoalSuccessfully() {
        when(goalRepository.save(any(Goal.class))).thenReturn(goal);
        Goal savedGoal = goalService.saveGoal(goal);
        assertNotNull(savedGoal);
        assertEquals(savedGoal.getTitle(), goal.getTitle());
    }

    @Test
    void shouldReturnGoalById() {
        when(goalRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(goal));
        Goal found = goalService.getGoalById(1L);
        assertNotNull(found);
        assertEquals(found.getId(), goal.getId());
    }

    // Additional tests for update, delete, etc.
}
