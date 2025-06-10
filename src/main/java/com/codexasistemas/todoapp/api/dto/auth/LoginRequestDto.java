package com.codexasistemas.todoapp.api.dto.auth;

public record LoginRequestDto(String email, String password) {

    // public LoginRequestDto {
    //     if (email == null || email.isBlank()) {
    //         throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
    //     }
    //     if (password == null || password.isBlank()) {
    //         throw new IllegalArgumentException("A senha não pode ser nula ou vazia.");
    //     }
    // }
    
}
