package com.codexasistemas.todoapp.api.service.interfaces;

import com.codexasistemas.todoapp.api.dto.auth.LoginRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.LoginResponseDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest);
    RegisterResponseDto register(RegisterRequestDto registerRequest);
}
