package com.funroom.coach.pa.service;


import com.funroom.coach.pa.model.Checkpoint;
import com.funroom.coach.pa.repository.CheckpointRepository;
import com.funroom.coach.pa.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {

    private final CheckpointRepository checkpointRepository;

    @Autowired
    public CheckpointServiceImpl(CheckpointRepository checkpointRepository) {
        this.checkpointRepository = checkpointRepository;
    }

    @Override
    public Checkpoint saveCheckpoint(Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint);
    }

    @Override
    public Checkpoint getCheckpointById(Long id) {
        return checkpointRepository.findById(id).orElse(null);
    }

    @Override
    public List<Checkpoint> getAllCheckpoints() {
        return checkpointRepository.findAll();
    }

    @Override
    public void deleteCheckpoint(Long id) {
        checkpointRepository.deleteById(id);
    }
}
