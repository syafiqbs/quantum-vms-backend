package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.User;
import com.oop442.project.service.UserService;

@RestController
@RequestMapping("/api/v1/admin")
public class UserController {

    @Autowired
    private UserService userService;

    // @PostMapping("/deleteUser")
    // public ResponseEntity<Object> deleteUser(@RequestBody User user) {
    //     User userToDelete = userService.findByEmail(user.getEmail()).get();
    //     if (userToDelete == null) {
    //         return ResponseEntity.badRequest().body("User not found");
    //     }
    //     userService.delete(userToDelete);
    //     return ResponseEntity.ok("User deleted");
    // }

    @PostMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        User userToUpdate = userService.findByEmail(user.getEmail()).get();
        if (userToUpdate == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());

        return ResponseEntity.ok(userService.save(userToUpdate));
    
    }

    @GetMapping("/getUser")
    public ResponseEntity<Object> getUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.findByEmail(user.getEmail()));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
