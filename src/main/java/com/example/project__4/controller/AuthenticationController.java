package com.example.project__4.controller;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.dto.response.AuthenticationResponse;
import com.example.project__4.dto.response.SignUpResponse;
import com.example.project__4.service.AuthenticationService;
import com.example.project__4.service.UserService;
import com.example.project__4.utils.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<AuthenticationResponse> login(@Valid  @RequestBody  AuthenticationDto authenticationDto){
        return new ResponseWrapper<>(true,"Success", authenticationService.authenticate(authenticationDto));
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<SignUpResponse> register(@Valid @RequestBody UserRequestDto userRequestDto){
        return new ResponseWrapper<>(true,"Success", authenticationService.register(userRequestDto));
    }
}
