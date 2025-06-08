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
            throw new RuntimeException("Nenhum usuário encontrado.");
        }
        return users.stream()
                .map(UserMapper::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        return UserMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto save(UserRequestDto userInfo) {
        if (userRepository.existsByEmail(userInfo.email())) {
            throw new IllegalArgumentException("Email já existe.");
        }
        User user = UserMapper.toEntity(userInfo);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto update(UserRequestDto userInfo) {
        if (userInfo.id() == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo para atualização.");
        }
        User user = userRepository.findById(userInfo.id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        
        if (!user.getEmail().equals(userInfo.email()) && 
            userRepository.existsByEmail(userInfo.email())) {
            throw new IllegalArgumentException("Email já existe.");
        }

        user = UserMapper.toEntity(userInfo);
        User updatedUser = userRepository.save(user);
        return UserMapper.toResponseDto(updatedUser);
    }

    @Override
    public UserResponseDto deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
        
        UserResponseDto responseDto = UserMapper.toResponseDto(user);
        userRepository.deleteById(id);
        return responseDto;
    }

    @Override
    public User findByIdEntity(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo.");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }
}
