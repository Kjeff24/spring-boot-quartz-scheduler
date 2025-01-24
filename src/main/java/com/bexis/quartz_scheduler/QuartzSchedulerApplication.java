package com.bexis.quartz_scheduler;

import com.bexis.quartz_scheduler.model.Task;
import com.bexis.quartz_scheduler.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class QuartzSchedulerApplication implements CommandLineRunner {
	private final TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(QuartzSchedulerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task1 = Task.builder()
				.name("Sleep time")
				.assignedTo("user1")
				.deadline(LocalDateTime.now().plusMinutes(10))
				.description("See to it you sleep")
				.responsibility("You are to sleep by then")
				.status("open")
				.createdBy("admin")
				.build();

		Task task2 = Task.builder()
				.name("Wake up time")
				.assignedTo("user1")
				.deadline(LocalDateTime.now().plusMinutes(15))
				.description("Alarm time")
				.responsibility("You are to wake up by then")
				.status("open")
				.createdBy("admin")
				.build();

		taskRepository.saveAll(List.of(task1, task2));
	}

}
