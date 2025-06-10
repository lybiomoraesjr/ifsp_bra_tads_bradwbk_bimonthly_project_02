package com.codexasistemas.todoapp.api.dto.auth;

public record RegisterResponseDto(String name, String email) {
    
    public RegisterResponseDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
        }
    }
    
}
