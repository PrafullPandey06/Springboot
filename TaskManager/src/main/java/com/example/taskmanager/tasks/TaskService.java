package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dtos.CreateTaskDto;
import com.example.taskmanager.tasks.dtos.TaskResponseDto;
import com.example.taskmanager.tasks.execptions.TaskNotFoundException;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }
//    public TaskEntity createTask(String title, String description, Date dueDate) {
//        TaskEntity task = new TaskEntity();
//        task.setTitle(title);
//        task.setDescription(description);
//        task.setCompleted(false);
//        task.setDueDate(dueDate);
//        return taskRepository.save(task);
//    }
    /*Model mapper dependency will map to createTaskDto to TaskEntity and in this way dto will carry data aroung process and when we need
    * to access this data we will first mapp that dto to righ Entity and then retreive data and to create mapper model we need to create
    * a logic of creating it's class only 1 time by using Bean concept in out main class*/
   public TaskResponseDto createTask(CreateTaskDto newTask) {
       // validate due date
       if (newTask.getDueDate().before(new Date(System.currentTimeMillis()))) {
           throw new IllegalArgumentException("Due date must be in the future");
       }
       TaskEntity task = modelMapper.map(newTask, TaskEntity.class);
       task.setCompleted(false);
       TaskEntity savedTask = taskRepository.save(task);
       return modelMapper.map(savedTask, TaskResponseDto.class);
   }
   // handle request to get one task by id
    public TaskResponseDto getTaskById(Long id) {
         TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
         return modelMapper.map(task, TaskResponseDto.class);
    }
}
