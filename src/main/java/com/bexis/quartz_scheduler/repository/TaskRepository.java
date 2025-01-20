package com.bexis.quartz_scheduler.repository;

import com.bexis.quartz_scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
