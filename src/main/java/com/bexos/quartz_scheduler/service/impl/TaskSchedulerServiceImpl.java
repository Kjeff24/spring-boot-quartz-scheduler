package com.bexos.quartz_scheduler.service.impl;

import com.bexos.quartz_scheduler.model.Task;
import com.bexos.quartz_scheduler.job.NotificationJob;
import com.bexos.quartz_scheduler.service.TaskSchedulerService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TaskSchedulerServiceImpl implements TaskSchedulerService {
    private final Scheduler scheduler;

    public void scheduleTask(Task task) throws SchedulerException {
        Date notificationDate = Date.from(task.getDeadline().atZone(ZoneId.systemDefault()).toInstant());

        JobDetail jobDetail = JobBuilder.newJob(NotificationJob.class)
                .withIdentity(String.valueOf(task.getTaskId()), "TaskNotifications")
                .usingJobData("taskId", String.valueOf(task.getTaskId()))
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(String.valueOf(task.getTaskId()), "TaskNotifications")
                .startAt(notificationDate)
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
