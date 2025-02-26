package com.bexos.quartz_scheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_task")
public class Task {
    @Id
    @GeneratedValue
    private long taskId;
    private String name;
    private String description;
    private String userComment;
    private String responsibility;
    private String assignedTo;
    private String status;
    private String createdBy;
    private LocalDateTime deadline;
    private LocalDateTime completedAt;
    private int hasSentDeadlineNotification;
    private int hasSentReminderNotification;
}
