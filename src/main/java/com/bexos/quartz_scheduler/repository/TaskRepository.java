package com.bexos.quartz_scheduler.repository;

import com.bexos.quartz_scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
