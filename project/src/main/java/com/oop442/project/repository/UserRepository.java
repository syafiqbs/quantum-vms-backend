package com.oop442.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop442.project.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
        
}
