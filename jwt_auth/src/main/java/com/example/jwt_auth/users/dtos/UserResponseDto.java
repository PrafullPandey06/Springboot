package com.example.jwt_auth.users.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String token;
}
