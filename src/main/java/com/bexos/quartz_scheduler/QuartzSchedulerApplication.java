package com.bexos.quartz_scheduler;

import com.bexos.quartz_scheduler.model.Task;
import com.bexos.quartz_scheduler.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class QuartzSchedulerApplication implements CommandLineRunner {
    private final TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(QuartzSchedulerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Task task1 = Task.builder()
                .name("Sleep time")
                .assignedTo("user1")
                .deadline(LocalDateTime.now().plusMinutes(1))
                .description("See to it you sleep")
                .responsibility("You are to sleep by then")
                .status("open")
                .createdBy("admin")
                .build();

        Task task2 = Task.builder()
                .name("Wake up time")
                .assignedTo("user1")
                .deadline(LocalDateTime.now().plusMinutes(2))
                .description("Alarm time")
                .responsibility("You are to wake up by then")
                .status("open")
                .createdBy("admin")
                .build();

        taskService.saveTask(task1);
        taskService.saveTask(task2);
    }

}
