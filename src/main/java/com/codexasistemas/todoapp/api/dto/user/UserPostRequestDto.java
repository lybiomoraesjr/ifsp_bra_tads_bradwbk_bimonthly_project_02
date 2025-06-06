package com.codexasistemas.todoapp.api.dto.user;

public record UserPostRequestDto(String name, String email, String password) {
    
    public UserPostRequestDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
    }
    
}
