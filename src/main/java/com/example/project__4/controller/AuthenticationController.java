package com.example.project__4.controller;


import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.response.LoginResponse;
import com.example.project__4.utils.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<LoginResponse> login(AuthenticationDto authenticationDto){
        return null;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseWrapper<String> register(){
        return  new ResponseWrapper<>(true, "Connection established");
    }
}
