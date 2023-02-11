package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "notes")
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String description;
    @ManyToOne(targetEntity = TaskEntity.class)
    private TaskEntity task;
}
