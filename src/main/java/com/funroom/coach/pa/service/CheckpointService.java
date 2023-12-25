package com.funroom.coach.pa.service;



import com.funroom.coach.pa.model.Checkpoint;

import java.util.List;

public interface CheckpointService {
    Checkpoint saveCheckpoint(Checkpoint checkpoint);
    Checkpoint getCheckpointById(Long id);
    List<Checkpoint> getAllCheckpoints();
    void deleteCheckpoint(Long id);
}
