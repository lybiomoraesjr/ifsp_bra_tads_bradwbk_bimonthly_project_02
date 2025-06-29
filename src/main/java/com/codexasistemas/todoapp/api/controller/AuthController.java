package com.codexasistemas.todoapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexasistemas.todoapp.api.dto.auth.LoginRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.LoginResponseDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterRequestDto;
import com.codexasistemas.todoapp.api.dto.auth.RegisterResponseDto;
import com.codexasistemas.todoapp.api.service.interfaces.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequest) {
        return ResponseEntity.ok().body(authService.register(registerRequest));
    }

}
