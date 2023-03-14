package com.oop442.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop442.project.entity.EmailDetails;
import com.oop442.project.service.EmailService;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "*")
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    
    @PostMapping("/sendEmail")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailDetails emailDetails) {
        return ResponseEntity.ok(emailService.sendSimpleMail(emailDetails));
    }

    // @PostMapping("/sendEmailWithAttachment")
    // public ResponseEntity<Object> sendEmailWithAttachment(@RequestBody EmailDetails emailDetails) {
    //     return ResponseEntity.ok(emailService.sendMailWithAttachment(emailDetails));
    // }
}
