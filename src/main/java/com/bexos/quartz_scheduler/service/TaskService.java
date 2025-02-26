package com.bexos.quartz_scheduler.service;

import com.bexos.quartz_scheduler.model.Task;

public interface TaskService {
    Task saveTask(Task task);
}
