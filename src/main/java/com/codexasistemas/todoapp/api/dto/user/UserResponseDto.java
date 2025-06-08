package com.codexasistemas.todoapp.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserResponseDto(
    @NotNull(message = "O ID é obrigatório.")
    @Positive(message = "O ID deve ser um número positivo.") Long id,
    
    @NotBlank(message = "O nome é obrigatório.") String name,
    
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.") String email
) {
    
    public UserResponseDto {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
        }
    }
} 