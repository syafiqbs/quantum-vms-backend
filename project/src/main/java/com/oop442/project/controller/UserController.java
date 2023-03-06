package com.oop442.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.User;
import com.oop442.project.service.UserService;

@RestController
@RequestMapping("/api/v1/admin")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Object> deleteUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.delete(user));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    
    }

    @GetMapping("/getUser")
    public ResponseEntity<Object> getUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.getUser(user.getEmail()));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
}
