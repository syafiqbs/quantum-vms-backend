package com.oop442.project.auth;

import com.oop442.project.config.JwtService;
import com.oop442.project.entity.Role;
import com.oop442.project.entity.User;
import com.oop442.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        
        var user = User
                .builder()
                .email(request.getEmail())
                .name(request.getName())
                .contactNumber(request.getContactNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .companyName(request.getCompanyName())
                .gstRegistrationNumber(request.getGstRegistrationNumber())
                .natureOfBusiness(request.getNatureOfBusiness())
                .role(Role.USER)
                .build();

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new IllegalStateException("Email already taken");
        }
        
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

        public Object changePassword(ChangePasswordRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new IllegalStateException("Old password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
        }

        public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var user = User
                .builder()
                .email(request.getEmail())
                .name(request.getName())
                .contactNumber(request.getContactNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
        }

        public AuthenticationResponse registerApprover(RegisterRequest request) {
                var user = User
                .builder()
                .email(request.getEmail())
                .name(request.getName())
                .contactNumber(request.getContactNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.APPROVER)
                .build();
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new IllegalStateException("Email already taken");
        }
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
        }
}
