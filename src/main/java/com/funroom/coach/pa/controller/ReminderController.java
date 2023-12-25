package com.funroom.coach.pa.controller;



import com.funroom.coach.pa.model.Reminder;
import com.funroom.coach.pa.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Reminder reminder = reminderService.getReminderById(id);
        return reminder != null ? ResponseEntity.ok(reminder) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminderDetails) {
        Reminder reminder = reminderService.getReminderById(id);
        if (reminder == null) {
            return ResponseEntity.notFound().build();
        }
        reminder.setReminderTime(reminderDetails.getReminderTime());
        reminder.setMessage(reminderDetails.getMessage());
        final Reminder updatedReminder = reminderService.saveReminder(reminder);
        return ResponseEntity.ok(updatedReminder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        Reminder reminder = reminderService.getReminderById(id);
        if (reminder == null) {
            return ResponseEntity.notFound().build();
        }
        reminderService.deleteReminder(id);
        return ResponseEntity.ok().build();
    }
}
