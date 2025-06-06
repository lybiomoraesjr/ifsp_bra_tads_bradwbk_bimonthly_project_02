package com.codexasistemas.todoapp.api.service.impl;

import com.codexasistemas.todoapp.api.dto.user.UserGetResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutResponseDto;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.IUserRepository;
import com.codexasistemas.todoapp.api.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserGetResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> new UserGetResponseDto(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    @Override
    public UserGetResponseDto findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        User user = findByIdEntity(id);
        return new UserGetResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public User findByIdEntity(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
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

    @Override
    public UserPutResponseDto update(UserPutRequestDto userInfo) {
        User user = findByIdEntity(userInfo.id());
        user.setName(userInfo.name());
        user.setEmail(userInfo.email());
        user.setPassword(userInfo.password());
        userRepository.save(user);
        return new UserPutResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
} 