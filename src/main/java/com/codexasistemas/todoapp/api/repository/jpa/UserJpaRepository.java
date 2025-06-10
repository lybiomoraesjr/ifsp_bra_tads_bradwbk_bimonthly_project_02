package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);
    public User findByEmail(String email);

}
