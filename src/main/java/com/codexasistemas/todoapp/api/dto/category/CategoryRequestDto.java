package com.codexasistemas.todoapp.api.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequestDto(
    @NotBlank(message = "O nome da categoria é obrigatório.")
    String name,
    
    @NotNull(message = "O ID do usuário é obrigatório.")
    Long userId
) {} 