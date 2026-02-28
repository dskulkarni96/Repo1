package com.example.jwtauth.service;

import com.example.jwtauth.dto.AuthResponse;
import com.example.jwtauth.dto.LoginRequest;
import com.example.jwtauth.dto.RegisterRequest;
import com.example.jwtauth.entity.Role;
import com.example.jwtauth.entity.User;
import com.example.jwtauth.repository.UserRepository;
import com.example.jwtauth.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthService {

	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;
	@Autowired
    private  JwtService jwtService;
	@Autowired
    private  AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {

        // Check if email already taken
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered: " + request.getEmail());
        }

        // Build and save new user
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        // Generate JWT
        String token = jwtService.generateToken(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setEmail(user.getEmail());
        authResponse.setRole(user.getRole().name());
        authResponse.setMessage("Registration successful");
        return authResponse;
    }

    public AuthResponse login(LoginRequest request) {

        // This will throw if credentials are wrong
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Credentials passed — load user and generate token
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setEmail(user.getEmail());
        authResponse.setRole(user.getRole().name());
        authResponse.setMessage("Login successful");
        return authResponse;
    }
}