package com.oop442.project.service;

import com.oop442.project.entity.User;

public interface UserService {
    User getUser(String email);

    Object findAll();

    User update(User user);

    Object delete(User user);
}
