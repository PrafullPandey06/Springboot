package com.example.taskmanager.tasks.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Date dueDate;
}

/*This is Data which will be send to response*/
