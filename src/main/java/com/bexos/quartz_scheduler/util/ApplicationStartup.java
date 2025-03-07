package com.bexos.quartz_scheduler.util;

import com.bexos.quartz_scheduler.model.Task;
import com.bexos.quartz_scheduler.repository.TaskRepository;
import com.bexos.quartz_scheduler.service.TaskSchedulerService;
import lombok.RequiredArgsConstructor;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartup {
    private final TaskRepository taskRepository;
    private final TaskSchedulerService taskSchedulerService;
    private final Scheduler scheduler;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        List<Task> tasks = taskRepository.findAll();

        for (Task task : tasks) {
            if (task.getHasSentDeadlineNotification() == 0) {
                try {
                    if (!scheduler.checkExists(new JobKey(String.valueOf(task.getTaskId()), "TaskNotifications"))) {
                        System.out.println(task.getTaskId());
                        taskSchedulerService.scheduleTask(task);
                        System.out.println("On start up scheduling, taskId: " + task.getTaskId());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
