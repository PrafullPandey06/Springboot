package com.example.jwt_auth.users.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String username;
    private String password;
}
