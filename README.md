# Quartz Scheduler with Spring Boot

## Overview
This project is a Quartz-based scheduling system integrated with Spring Boot. It schedules tasks based on deadlines and triggers notifications accordingly.

## Features
- Uses **Quartz Scheduler** to manage job execution.
- Loads tasks from the database on application startup and schedules them.
- Supports dynamic task scheduling based on deadlines.

## Tech Stack
- **Java** (Spring Boot)
- **Quartz Scheduler**
- **Spring Data JPA**
- **Lombok**
- **H2/PostgreSQL** (Choose based on configuration)

## Project Structure
```
java
├── com.bexos.quartz_scheduler
    ├── QuartzSchedulerApplication.java
    ├── config
    │   └── QuartzConfig.java
    ├── dto
    │   ├── MessageResponse.java
    │   └── TaskRequest.java
    ├── exception
    │   ├── BadRequestException.java
    │   ├── GlobalExceptionHandler.java
    │   └── NotFoundException.java
    ├── job
    │   └── NotificationJob.java
    ├── model
    │   └── Task.java
    ├── repository
    │   └── TaskRepository.java
    ├── service
    │   ├── NotificationService.java
    │   ├── TaskSchedulerService.java
    │   ├── TaskService.java
    │   └── impl
    │       ├── NotificationServiceImpl.java
    │       ├── TaskSchedulerServiceImpl.java
    │       └── TaskServiceImpl.java
    └── util
        └── ApplicationStartup.java
└── resources
    ├── application-dev.yml
    ├── application-prod.yml
    ├── application.properties

```

## Configuration
### 1. Quartz Configuration
Located in `QuartzConfig.java`, this configures the Quartz Scheduler factory and initializes the scheduler.

### 2. Task Scheduling
- `ApplicationStartup.java` loads pending tasks on startup and schedules them.
- `TaskSchedulerServiceImpl.java` schedules individual tasks with Quartz.

## Running the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/quartz-scheduler.git
   ```
2. Navigate to the project directory:
   ```sh
   cd quartz-scheduler
   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```

## How It Works
1. **On Application Startup**:
    - Fetches all stored tasks from the database.
    - Schedules tasks with deadlines that haven't been notified yet.
2. **Task Scheduling**:
    - A `Task` entity contains a `deadline` field.
    - The `TaskSchedulerServiceImpl` schedules jobs using `Quartz Scheduler`.
3. **Notification Execution**:
    - Quartz triggers the `NotificationJob` at the scheduled time.

## Customization
- Modify `TaskSchedulerServiceImpl.java` to add more job logic.
- Change `ApplicationStartup.java` to load tasks differently.
- Configure spring profiles in `application.yml` in order to use persistence database.
