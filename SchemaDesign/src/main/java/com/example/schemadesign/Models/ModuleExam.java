package com.example.schemadesign.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ModuleExam extends BaseModel{
    @ManyToOne
    private Module module; // ModuleExam : Module(cardinality)
                           // 1 : 1 (1 module exam will have exam of that 1 module only but 1 module can have many module)
                           // M : 1 (1 module can have multiple exam)
    @ManyToOne //(Many = "ModuleExam" && One = "Exam")
    private Exam exam;  // ModuleExam : Exam(cardinality)
}
// if type of an attribute is an entity then it is a relationship between those 2 classes
// than we must specify cardinality of relationship so that springboot can create tables appropriately

// cardinality between module and moduleExam is 1 : 1
// 1 module exam will have exam of that 1 module only but 1 module can have many module exam
// example: module_id,exam_id
//          (2,4),(2,5),(2,7)
// so ModuleExam : Module -> m:1

//---------------------------------------------
// 1 Module exam object will be createed for exam
// and 1 exam will have many module exam so  M:1
//-----------------------------------------------
// whatever the first thing it is going to talk about current class and other thing about different class
// -------------------------------------------------------------------------------------------------------
// behind the scenes
// ModuleExam{
//  Module module; M:1 (module_id in ModuleExam table)
//   Exam exam; M:1 (exam_id in ModuleExam table)
//   }
// ModuleExam Table : module_id | exam_id