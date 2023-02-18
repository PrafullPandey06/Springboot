package com.example.jwt_auth.users.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CreateUserDto {

    private String username;

    private String email;

    private String password; // will save a hashed password
}
