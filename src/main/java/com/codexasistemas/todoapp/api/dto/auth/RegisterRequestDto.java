package com.codexasistemas.todoapp.api.dto.auth;

public record RegisterRequestDto(String name, String email, String password) {

    public RegisterRequestDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia.");
        }
    }
    
}
