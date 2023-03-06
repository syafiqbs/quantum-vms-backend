package com.oop442.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oop442.project.entity.User;
import com.oop442.project.error.UserNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    List<User> users = new ArrayList<>();

    @Override
    public Optional<User> findByEmail(String email) {

        User userEntity = users
                        .stream()
                        .filter(user -> user.getEmail().equals(email))
                        .findFirst()
                        .orElseThrow(() -> new UserNotFoundException("User not found"));

        return Optional.of(userEntity);
    
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
    
}
