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

import com.codexasistemas.todoapp.api.dto.user.UserRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserResponseDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryWithTaskCountDto;
import com.codexasistemas.todoapp.api.dto.tag.TagWithTaskCountDto;
import com.codexasistemas.todoapp.api.dto.task.TaskResponseDto;
import com.codexasistemas.todoapp.api.service.impl.UserServiceImpl;
import com.codexasistemas.todoapp.api.service.interfaces.TaskService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto user) {
        return ResponseEntity.ok().body(userService.save(user));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto user) {
        user = new UserRequestDto(id, user.name(), user.email(), user.password());
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.deleteById(id));
    }

    @GetMapping("/{id}/categories")
    public ResponseEntity<List<CategoryWithTaskCountDto>> getUserCategories(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findCategoriesWithTaskCount(id));
    }

    @GetMapping("/{id}/tags")
    public ResponseEntity<List<TagWithTaskCountDto>> getUserTags(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findTagsWithTaskCount(id));
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskResponseDto>> getUserTasks(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findByUserId(id));
    }
}
