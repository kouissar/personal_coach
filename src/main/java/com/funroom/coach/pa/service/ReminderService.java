package com.funroom.coach.pa.service;


import com.funroom.coach.pa.model.Reminder;
import java.util.List;

public interface ReminderService {
    Reminder saveReminder(Reminder reminder);
    Reminder getReminderById(Long id);
    List<Reminder> getAllReminders();
    void deleteReminder(Long id);
}
