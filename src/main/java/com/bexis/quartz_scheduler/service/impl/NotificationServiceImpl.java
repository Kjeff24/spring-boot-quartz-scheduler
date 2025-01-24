package com.bexis.quartz_scheduler.service.impl;

import com.bexis.quartz_scheduler.model.Task;
import com.bexis.quartz_scheduler.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    public void sendNotification(Task task) {
        System.out.println("Sending notification for Task: " + task.getName());
        // Implement email, SMS, or push notification logic
    }
}
