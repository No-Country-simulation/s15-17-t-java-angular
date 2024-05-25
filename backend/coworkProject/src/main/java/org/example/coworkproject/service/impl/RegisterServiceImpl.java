package org.example.coworkproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.coworkproject.configuration.security.jwt.JwtService;
import org.example.coworkproject.dto.request.RegisterRequestDTO;
import org.example.coworkproject.dto.response.RegisterResponseDTO;
import org.example.coworkproject.entity.UserEntity;
import org.example.coworkproject.exception.ExceptionMethods;
import org.example.coworkproject.exception.InvalidPasswordException;
import org.example.coworkproject.exception.MyException;
import org.example.coworkproject.repository.UserRepository;
import org.example.coworkproject.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO requestDTO) throws MyException {

        validatePassword(requestDTO);

        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("There is already a user registered with the email: " + requestDTO.getEmail());
        }

        if (requestDTO.getEmail() == null || ExceptionMethods.onlySpaces(requestDTO.getEmail())) {
            System.out.println("Email can't be null or empty.");
            return null;
        }

        var user = UserEntity.builder()
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .name(requestDTO.getName())
                .lastName(requestDTO.getLastName())
                .profilePicture(requestDTO.getProfilePicture())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        Long id = user.getId_user();
        String email = user.getEmail();
        String lastName = user.getLastName();
        String name = user.getName();
        String profilePicture = user.getProfilePicture();

        return RegisterResponseDTO.builder()
                .id(id)
                .lastName(lastName)
                .name(name)
                .token(jwtToken)
                .email(email)
                .build();
    }


    public void validatePassword(RegisterRequestDTO requestDTO) throws InvalidPasswordException {

        if (!StringUtils.hasText(requestDTO.getPassword()) || !StringUtils.hasText(requestDTO.getRepeatedPassword())) {
            throw new InvalidPasswordException("One or both passwords are empty.");
        }

        if (!requestDTO.getPassword().equals(requestDTO.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match.");
        }
    }


}
