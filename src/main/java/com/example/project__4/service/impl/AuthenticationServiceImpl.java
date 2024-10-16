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
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


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
        return SignUpResponse.
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationDto authenticationDto) {
        return null;
    }
}
