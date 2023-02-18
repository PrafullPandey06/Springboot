package com.example.schemadesign.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Module extends BaseModel{
    private String name;
    @ManyToMany
    private List<Student> enrolledStudents;
    @OneToMany(mappedBy = "module")
    private List<ModuleExam> moduleExams;
}
