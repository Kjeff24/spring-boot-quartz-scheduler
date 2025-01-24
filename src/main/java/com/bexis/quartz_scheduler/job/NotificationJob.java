package com.bexis.quartz_scheduler.job;

import com.bexis.quartz_scheduler.model.Task;
import com.bexis.quartz_scheduler.repository.TaskRepository;
import com.bexis.quartz_scheduler.service.NotificationService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationJob implements Job {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private TaskRepository taskRepository;

    public NotificationJob() {
    }

//    public NotificationJob(NotificationService notificationService, TaskRepository taskRepository) {
//        this.notificationService = notificationService;
//        this.taskRepository = taskRepository;
//    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String taskId = jobExecutionContext.getJobDetail().getJobDataMap().getString("taskId");
        System.out.println("taskId: " + Long.valueOf(taskId));
        Task task = taskRepository.findById(Long.valueOf(taskId)).orElse(null);

        if (task != null && task.getHasSentDeadlineNotification() == 0) {
            notificationService.sendNotification(task);
            task.setHasSentDeadlineNotification(1);
            taskRepository.save(task);
        }
    }
}
