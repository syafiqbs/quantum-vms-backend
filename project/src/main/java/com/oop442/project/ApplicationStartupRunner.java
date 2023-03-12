package com.oop442.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oop442.project.entity.Role;
import com.oop442.project.entity.User;
import com.oop442.project.repository.UserRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setPassword("$2a$10$Jw/pKkihLbACN6mXs7SFnOV2VrIKgmd8CHhtvRTk5fQvDU3Agn/Za");
            user.setEmail("admin@admin.com");
            user.setName("Admin");
            user.setContactNumber("0123456789");
            user.setRole(Role.ADMIN);
            userRepository.save(user);
        }
        System.out.println("Application Running \n To kill this application, press Ctrl + C.");
    }
    
}
