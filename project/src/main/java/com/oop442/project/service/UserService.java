package com.oop442.project.service;


import com.oop442.project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService{

    Optional<User> findByEmail(String email);

    User save(User user);

    List<User> getAllUsers();
}
