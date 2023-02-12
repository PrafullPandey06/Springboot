package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dtos.CreateTaskDto;
import com.example.taskmanager.tasks.dtos.TaskResponseDto;
import com.example.taskmanager.tasks.execptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
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
    // get task by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long id) {
     //   TaskResponseDto task = taskService.getTaskById(id);
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    // Each controller will have it's own controller level exception handler
    @ExceptionHandler({
            IllegalArgumentException.class,
            TaskNotFoundException.class
    })
    public ResponseEntity<String> handleException(Exception e) {
        if(e instanceof TaskNotFoundException)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()));
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
