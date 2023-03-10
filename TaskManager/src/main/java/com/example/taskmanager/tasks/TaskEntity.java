package com.example.taskmanager.tasks;

import com.example.taskmanager.notes.NotesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    @Column(unique = true)
    private Date dueDate;

    @OneToMany(targetEntity = NotesEntity.class, cascade = CascadeType.ALL)
    private List<NotesEntity> notes;
}
