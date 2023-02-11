package com.example.taskmanager.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    @GetMapping("")
    public String getAllNoetsByTaskId(@PathVariable("taskId") Long taskId ){
        return "All notes for task with id: "+taskId;
    }

}
