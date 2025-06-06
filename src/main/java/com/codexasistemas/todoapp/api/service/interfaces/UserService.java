package com.codexasistemas.todoapp.api.service.interfaces;

import com.codexasistemas.todoapp.api.dto.user.UserGetResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutResponseDto;
import com.codexasistemas.todoapp.api.model.User;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserGetResponseDto> findAll();
    UserGetResponseDto findById(Long id);
    User findByIdEntity(Long id);
    UserPostResponseDto save(UserPostRequestDto userInfo);
    UserPutResponseDto update(UserPutRequestDto userInfo);
    ResponseEntity<?> deleteById(Long id);
} 