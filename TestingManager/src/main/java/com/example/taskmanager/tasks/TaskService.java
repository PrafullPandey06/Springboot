package com.example.taskmanager.tasks;

import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(String title, String description, Date dueDate) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        task.setDueDate(dueDate);
        return taskRepository.save(task);
    }
}

