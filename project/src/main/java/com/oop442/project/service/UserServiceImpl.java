package com.oop442.project.service;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.User;
import com.oop442.project.error.UserNotFoundException;

import com.oop442.project.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public User getAdmin(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public Object findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User userToUpdate = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new UserNotFoundException(user.getEmail()));
        // userToUpdate.setEmail(user.getEmail());
        // userToUpdate.setName(user.getName());
        // userToUpdate.setContactNumber(user.getContactNumber());
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(user) != null) {
                    field.set(userToUpdate, field.get(user));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException("Error while updating User Details");
            }
        }
        
        return userRepository.save(userToUpdate);
        
    }

    @Override
    public Object delete(String email) {
        User userToDelete = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
        userRepository.delete(userToDelete);
        return userToDelete;
    }
    
}
