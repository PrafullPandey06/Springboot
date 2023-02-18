package com.example.schemadesign.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private Long id;
    @CreatedDate     // spring will automatically set the date when the object is created
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
// this is class which contains the common fields for all the models
// like id, createdAt, updatedAt
// this class will not be stored at database but it's attribute are stored at all the places so that we can use them so
// we have to annotate it with @MappedSuperclass
// @ColumnName(name="id") // if we want to change the name of the column