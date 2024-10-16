package com.example.project__4.service.impl;

import com.example.project__4.config.JwtService;
import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.dto.response.AuthenticationResponse;
import com.example.project__4.dto.response.SignUpResponse;
import com.example.project__4.entity.User;
import com.example.project__4.enums.UserRole;
import com.example.project__4.exception.InvalidUserCredentialException;
import com.example.project__4.exception.UserAlredyExistsException;
import com.example.project__4.repository.UserRepository;
import com.example.project__4.service.AuthenticationService;
import com.example.project__4.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Override
    public SignUpResponse register(UserRequestDto userRequestDto) {
        if (userService.userExits(userRequestDto.getEmail())) {
            throw new UserAlredyExistsException("User with email already exists");
        }
        if (!userRequestDto.getPassword().equals(userRequestDto.getConfirmPassword())){
            throw new InvalidUserCredentialException("Password and Confirm password do not match");
        }
        User user = User
                .builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getFirstname() + " " + userRequestDto.getFirstname())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .role(UserRole.USER)
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .build();
        User saveduser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        Date expiresAt = jwtService.extractClaims(jwtToken, Claims::getExpiration);
        return SignUpResponse
                .builder()
                .email(saveduser.getEmail())
                .token(jwtToken)
                .expiresAt(expiresAt)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationDto authenticationDto) {
        if(!userService.userExits(authenticationDto.getEmail())){
            throw new InvalidUserCredentialException("Invalid username or password");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getEmail(),
                        authenticationDto.getPassword()
                )
        );

        var user = userService.fetchUser(authenticationDto);
        var token = jwtService.generateToken(user);
        return  AuthenticationResponse
                .builder()
                .email(user.getEmail())
                .expiresAt(jwtService.extractClaims(token, Claims::getExpiration))
                .token(token)
                .build();

    }
}
