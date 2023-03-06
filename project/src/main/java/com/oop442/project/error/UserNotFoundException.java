package com.oop442.project.error;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(String email) {
        super("User not found with email: " + email);
    }
}
