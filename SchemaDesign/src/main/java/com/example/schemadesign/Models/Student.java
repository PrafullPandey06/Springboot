package com.example.schemadesign.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Student extends BaseModel {
  private String name;
  private String email;
  private String address;
  private String phoneNumber;
  private String password;
  @ManyToMany(mappedBy = "enrolledStudents")
  private List<Module> enrolledModules;
}
// RealtionShip between Student and Module
// Student : Module
// 1 -> M (1 student can enroll for many modules)
// M -> 1 (1 module can have many students)

//--------------------------------------------------
//Why MappedBy? (to prevent creation of duplicate table)
// when we create many to many relationship than we chosse it as a list of that entity
// so when we create a list of that entity than we must specify which entity is the owner of the relationship
// so we use mappedBy so that both entity don't create a table for that relationship(duplicate relationship)

// it is used in one to many and many to many