package com.oop442.project.auth;

import com.oop442.project.config.JwtService;
import com.oop442.project.entity.PerformanceEvaluationForm;
import com.oop442.project.entity.PreEvaluationForm;
import com.oop442.project.entity.Role;
import com.oop442.project.entity.User;
import com.oop442.project.entity.VendorAssessmentForm;
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
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var vendorAssessmentForm = new VendorAssessmentForm();

        var performanceEvaluationForm = new PerformanceEvaluationForm();
        
        var preEvaluationForm = new PreEvaluationForm();
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new IllegalStateException("Email already taken");
        }
        preEvaluationForm.setUser(user);
        performanceEvaluationForm.setUser(user);
        vendorAssessmentForm.setUser(user);
        user.setPerformanceEvaluationForm(performanceEvaluationForm);
        user.setPreEvaluationForm(preEvaluationForm);
        user.setVendorAssessmentForm(vendorAssessmentForm);
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
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
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
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
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
