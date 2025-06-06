package com.codexasistemas.todoapp.api.dto.user;

public record UserGetResponseDto(Long id, String name, String email) {

    public UserGetResponseDto {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
    
}
