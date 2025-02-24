package com.bexis.quartz_scheduler.service.impl;

import com.bexis.quartz_scheduler.model.Task;
import com.bexis.quartz_scheduler.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    public void sendNotification(Task task) {
        System.out.println(LocalDateTime.now() + " - sending notification for Task: " + task);
        // Implement email, SMS, or push notification logic
    }
}
