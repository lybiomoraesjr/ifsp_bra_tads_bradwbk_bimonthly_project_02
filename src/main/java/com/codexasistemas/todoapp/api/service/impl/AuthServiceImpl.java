package com.codexasistemas.todoapp.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codexasistemas.todoapp.api.dto.auth.LoginRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterResponseDto;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.interfaces.UserRepository;
import com.codexasistemas.todoapp.api.service.interfaces.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.email());
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado com o email: " + loginRequest.email());
        }

        if (!user.getPassword().equals(loginRequest.password())) {
            throw new IllegalArgumentException("Senha incorreta.");
        }

        return "Usuário logado com sucesso.";
    }

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequest) {
        User user = new User();
        
        user.setName(registerRequest.name());
        user.setEmail(registerRequest.email());
        user.setPassword(registerRequest.password());
        user = userRepository.save(user);

        return new RegisterResponseDto(user.getName(), user.getEmail());
    }

}
