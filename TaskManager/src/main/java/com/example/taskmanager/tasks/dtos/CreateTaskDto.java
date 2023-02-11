package com.example.taskmanager.tasks.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CreateTaskDto {
    @NonNull
    private String title;
    private String description;
    @NonNull
    private Date dueDate;
}
