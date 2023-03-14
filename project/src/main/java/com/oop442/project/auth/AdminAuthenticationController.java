package com.oop442.project.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/admin")
@RequiredArgsConstructor
public class AdminAuthenticationController {

    private final AuthenticationService service;
    @CrossOrigin("*")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ) {

        return ResponseEntity.ok(service.register(request));
    }
    @CrossOrigin("*")
    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerAdmin(request));
    }
    @CrossOrigin("*")
    @PostMapping("/registerApprover")
    public ResponseEntity<AuthenticationResponse> registerApprover(
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerApprover(request));
    }

}
