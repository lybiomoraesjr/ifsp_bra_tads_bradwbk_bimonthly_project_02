package com.codexasistemas.todoapp.api.dto.user;

public record UserPostResponseDto(Long id, String name, String email) {

    public UserPostResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
}
