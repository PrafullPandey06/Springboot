package com.example.taskmanager.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TaskServiceTests {
    @Autowired private TaskRepository taskRepository;

    @Test
    public void createTask() {
        TaskService taskService = new TaskService(taskRepository);
        TaskEntity task = taskService.createTask("title", "description", new java.sql.Date(0));
        System.out.println(task);
    }

}
