package com.example.schemadesign.Models;

import jakarta.persistence.Entity;

@Entity
public class StudentModuleExam extends BaseModel{
    private Student student;
    private ModuleExam moduleExam;
}
// Realtionship is created between 2 entities only this is mapping class
//-----------------------------------------------------------------------
// SME : S
// 1 : 1 (1 object of studentmoduleexam is associated to 1 student)
// M : 1 (1 object of student is associated to many studentModuleExam bcoz 1 student can enroll for many modules)
// I've an object with ME id = 21
// For that module that exam can be given by many students