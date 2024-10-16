package com.example.project__4.controller;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.response.AuthenticationResponse;
import com.example.project__4.service.UserService;
import com.example.project__4.utils.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<AuthenticationResponse> login(AuthenticationDto authenticationDto){
        return null;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public  String register(){
        //return  new ResponseWrapper<>(true, "Connection established");
        //return  "Connection established";
        //return userService.createUser()

        return  null;
    }
}
