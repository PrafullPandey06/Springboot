package com.example.taskmanager.tasks.execptions;

public class TaskNotFoundException extends IllegalArgumentException{
    public TaskNotFoundException(Long id) {
        super("Task with id: " + id + " not found");
    }
}
