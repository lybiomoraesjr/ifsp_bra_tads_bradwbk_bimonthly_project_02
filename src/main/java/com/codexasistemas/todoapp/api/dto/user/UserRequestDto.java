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
            throw new IllegalArgumentException("ID must be a positive number");
        }
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

    // Constructor for POST requests (without id)
    public UserRequestDto(String name, String email, String password) {
        this(null, name, email, password);
    }
} 