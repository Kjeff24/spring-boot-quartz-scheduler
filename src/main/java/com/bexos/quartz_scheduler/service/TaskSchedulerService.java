package com.bexos.quartz_scheduler.service;

import com.bexos.quartz_scheduler.model.Task;
import org.quartz.SchedulerException;

public interface TaskSchedulerService {
    void scheduleTask(Task task) throws SchedulerException;
}
