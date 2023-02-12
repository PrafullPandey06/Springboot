package com.example.taskmanager.common;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseDto {
    @NonNull
    private String message;

}
