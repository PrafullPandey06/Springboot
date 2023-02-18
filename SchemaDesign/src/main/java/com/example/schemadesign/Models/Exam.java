package com.example.schemadesign.Models;

import jakarta.persistence.Entity;

@Entity
public class Exam extends BaseModel {
    private int duration;
    private String name;
}
