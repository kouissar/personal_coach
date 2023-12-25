package com.funroom.coach.pa.service;



import com.funroom.coach.pa.model.Reminder;
import com.funroom.coach.pa.repository.ReminderRepository;
import com.funroom.coach.pa.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public Reminder getReminderById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    @Override
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }
}
