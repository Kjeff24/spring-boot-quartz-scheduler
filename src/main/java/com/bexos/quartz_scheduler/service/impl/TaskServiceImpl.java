package com.bexos.quartz_scheduler.service.impl;

import com.bexos.quartz_scheduler.model.Task;
import com.bexos.quartz_scheduler.repository.TaskRepository;
import com.bexos.quartz_scheduler.service.TaskSchedulerService;
import com.bexos.quartz_scheduler.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskSchedulerService taskSchedulerService;

    @Transactional
    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);

        try {
            taskSchedulerService.scheduleTask(savedTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());; // Handle scheduling exception
        }

        return savedTask;
    }
}
