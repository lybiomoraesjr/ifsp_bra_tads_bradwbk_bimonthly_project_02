package com.codexasistemas.todoapp.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codexasistemas.todoapp.api.dto.user.UserRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserResponseDto;
import com.codexasistemas.todoapp.api.mapper.UserMapper;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.interfaces.UserRepository;
import com.codexasistemas.todoapp.api.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(UserMapper::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto save(UserRequestDto userInfo) {
        if (userRepository.existsByEmail(userInfo.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user = UserMapper.toEntity(userInfo);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto update(UserRequestDto userInfo) {
        if (userInfo.id() == null) {
            throw new IllegalArgumentException("ID must not be null for update");
        }
        User user = userRepository.findById(userInfo.id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        if (!user.getEmail().equals(userInfo.email()) && 
            userRepository.existsByEmail(userInfo.email())) {
            throw new IllegalArgumentException("Email already exists");
        }

        user = UserMapper.toEntity(userInfo);
        User updatedUser = userRepository.save(user);
        return UserMapper.toResponseDto(updatedUser);
    }

    @Override
    public UserResponseDto deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        UserResponseDto responseDto = UserMapper.toResponseDto(user);
        userRepository.deleteById(id);
        return responseDto;
    }

    @Override
    public User findByIdEntity(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
