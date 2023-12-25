package com.funroom.coach.pa.controller;



import com.funroom.coach.pa.model.Checkpoint;
import com.funroom.coach.pa.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkpoints")
public class CheckpointController {

    private final CheckpointService checkpointService;

    @Autowired
    public CheckpointController(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @GetMapping
    public List<Checkpoint> getAllCheckpoints() {
        return checkpointService.getAllCheckpoints();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkpoint> getCheckpointById(@PathVariable Long id) {
        Checkpoint checkpoint = checkpointService.getCheckpointById(id);
        return checkpoint != null ? ResponseEntity.ok(checkpoint) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Checkpoint createCheckpoint(@RequestBody Checkpoint checkpoint) {
        return checkpointService.saveCheckpoint(checkpoint);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkpoint> updateCheckpoint(@PathVariable Long id, @RequestBody Checkpoint checkpointDetails) {
        Checkpoint existingCheckpoint = checkpointService.getCheckpointById(id);
        if (existingCheckpoint == null) {
            return ResponseEntity.notFound().build();
        }
        existingCheckpoint.setName(checkpointDetails.getName());
        existingCheckpoint.setStatus(checkpointDetails.getStatus());
        // Update other fields as necessary
        final Checkpoint updatedCheckpoint = checkpointService.saveCheckpoint(existingCheckpoint);
        return ResponseEntity.ok(updatedCheckpoint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckpoint(@PathVariable Long id) {
        Checkpoint checkpoint = checkpointService.getCheckpointById(id);
        if (checkpoint == null) {
            return ResponseEntity.notFound().build();
        }
        checkpointService.deleteCheckpoint(id);
        return ResponseEntity.ok().build();
    }
}

