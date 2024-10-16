package com.example.project__4.service;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.dto.response.AuthenticationResponse;
import com.example.project__4.dto.response.SignUpResponse;

public interface AuthenticationService {
    SignUpResponse register(UserRequestDto userRequestDto);
    AuthenticationResponse authenticate(AuthenticationDto authenticationDto);
}
