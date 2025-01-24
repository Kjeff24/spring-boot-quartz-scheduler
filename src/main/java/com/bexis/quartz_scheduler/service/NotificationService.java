package com.bexis.quartz_scheduler.service;

import com.bexis.quartz_scheduler.model.Task;

public interface NotificationService {
    void sendNotification(Task task);
}
