package com.example.taskmanager.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TaskServiceTests {

    @Autowired private TaskRepository taskRepository;

    @Test
    public void testCreateTask() {
        TaskService taskService = new TaskService(taskRepository);

        TaskEntity task = taskService.createTask(
                "test task",
                "test description",
                new Date()
        );

        System.out.println(task);
    }
}
