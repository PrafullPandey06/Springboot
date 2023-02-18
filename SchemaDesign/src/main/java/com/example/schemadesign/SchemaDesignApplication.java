package com.example.schemadesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchemaDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchemaDesignApplication.class, args);
    }

}

// Models are entities which are present in the database
// Path: src\main\java\com\example\schemadesign\Models\Student.java
// Find relation between Entities and store relation in Model