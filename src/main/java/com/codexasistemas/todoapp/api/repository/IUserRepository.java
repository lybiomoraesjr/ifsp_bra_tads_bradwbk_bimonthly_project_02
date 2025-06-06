package com.codexasistemas.todoapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);
    
}
