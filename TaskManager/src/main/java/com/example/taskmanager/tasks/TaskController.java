package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dtos.CreateTaskDto;
import com.example.taskmanager.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String getTasks() {
        return ""; //TODO: taskService.getTasks()
    }
    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto createTask) { // @RequestBody: convert json to CreateTaskDto
        TaskResponseDto savedTask = taskService.createTask(createTask); // carrying taskEntity data around process
        return ResponseEntity.created(URI.create("/tasks/" + savedTask.getId()))
                .body(savedTask); // return 201 created status code and send back savedTask
    }
    @GetMapping("/{id}")
    public String getTask(@PathVariable Long id) {
        return ""; //TODO: taskService.getTask()
    }
}
