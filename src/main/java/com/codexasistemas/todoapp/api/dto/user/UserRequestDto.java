package com.codexasistemas.todoapp.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UserRequestDto(
    @Positive(message = "O ID deve ser um número positivo.") Long id,
    
    @NotBlank(message = "O nome é obrigatório.") String name,
    
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.") String email,
    
    @NotBlank(message = "A senha é obrigatória.") String password
) {
    public UserRequestDto {
        if (id != null && id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
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

    // Constructor for POST requests (without id)
    public UserRequestDto(String name, String email, String password) {
        this(null, name, email, password);
    }
} 