package com.oop442.project.service;

import com.oop442.project.entity.User;

public interface UserService {
    
    User getUser(String email);

    User getAdmin(String email);

    Object findAll();

    User update(User user);

    Object delete(String email);
}
