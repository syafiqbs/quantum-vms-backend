package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.User;
import com.oop442.project.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/admin/deleteUser")
    public ResponseEntity<Object> deleteUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.delete(user.getEmail()));
    }

    @PutMapping("/admin/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    
    }

    @PostMapping("/vendor/getUser")
    public ResponseEntity<Object> getUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.getUser(user.getEmail()));
    }

    @PostMapping("/admin/getAdmin")
    public ResponseEntity<Object> getAdmin(@RequestBody User user) {
        return ResponseEntity.ok(userService.getAdmin(user.getEmail()));
    }

    @GetMapping("/admin/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
}
