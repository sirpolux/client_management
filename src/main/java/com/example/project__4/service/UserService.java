package com.example.project__4.service;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.entity.User;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);
    User fetchUser(AuthenticationDto authenticationDto);
}
