package com.oop442.project.service;

import org.springframework.stereotype.Service;

import com.oop442.project.entity.User;
import com.oop442.project.error.UserNotFoundException;
import com.oop442.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
        
    }

    @Override
    public Object findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User userToUpdate = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new UserNotFoundException(user.getEmail()));
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userRepository.save(userToUpdate);
        return userToUpdate;
        
    }

    @Override
    public Object delete(User user) {
        User userToDelete = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new UserNotFoundException(user.getEmail()));
        userRepository.delete(userToDelete);
        return userToDelete;
    }
    
}
