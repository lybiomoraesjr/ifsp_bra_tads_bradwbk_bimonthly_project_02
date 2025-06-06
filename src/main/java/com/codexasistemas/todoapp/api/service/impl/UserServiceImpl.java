package com.codexasistemas.todoapp.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codexasistemas.todoapp.api.dto.user.UserGetResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutResponseDto;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.interfaces.UserRepository;


@Service
public class UserServiceImpl {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserGetResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> new UserGetResponseDto(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    public UserGetResponseDto findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserGetResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserPostResponseDto save(UserPostRequestDto userInfo) {
        User user = new User();
        user.setName(userInfo.name());
        user.setEmail(userInfo.email());
        user.setPassword(userInfo.password());
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Name, email, and password must not be null");
        }
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Name, email, and password must not be empty");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        userRepository.save(user);
        return new UserPostResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserPutResponseDto update(UserPutRequestDto userInfo) {
        User user = userRepository.findById(userInfo.id()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(userInfo.name());
        user.setEmail(userInfo.email());
        user.setPassword(userInfo.password());
        userRepository.save(user);
        return new UserPutResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public ResponseEntity<?> deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
       
    }
}
