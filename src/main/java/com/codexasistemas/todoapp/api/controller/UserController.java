package com.codexasistemas.todoapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexasistemas.todoapp.api.dto.user.UserGetResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPostResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserPutResponseDto;
import com.codexasistemas.todoapp.api.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserGetResponseDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<UserPostResponseDto> save(@RequestBody UserPostRequestDto user) {
        return ResponseEntity.ok().body(userService.save(user));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserPutResponseDto> update(@PathVariable Long id, @RequestBody UserPutRequestDto user) {
        user = new UserPutRequestDto(id, user.name(), user.email(), user.password());
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

}
