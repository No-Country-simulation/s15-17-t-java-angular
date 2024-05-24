package org.example.coworkproject.service.impl;

import org.example.coworkproject.configuration.security.jwt.JwtService;
import org.example.coworkproject.dto.request.LoginRequestDTO;
import org.example.coworkproject.dto.response.LoginResponseDTO;
import org.example.coworkproject.exception.CustomAuthenticationException;
import org.example.coworkproject.repository.UserRepository;
import org.example.coworkproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new CustomAuthenticationException("Incorrect password");
        } catch (AuthenticationException ex) {
            throw new CustomAuthenticationException("Authentication failed");
        }

        var user = userRepository.findUserByEmail(requestDTO.getEmail()).orElse(null);

        if (user == null) {
            System.out.println("It wasn't possible to find a user with the email: " + requestDTO.getEmail());
            return null;
        }

        var jwtToken = jwtService.generateToken(user);

        String email = user.getEmail();
        Long id_user = user.getId_user();
        String name = user.getName();
        String lastName = user.getLastName();

        return LoginResponseDTO.builder()
                .email(email)
                .id_user(id_user)
                .token(jwtToken)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
