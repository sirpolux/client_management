package com.example.project__4.service.impl;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.entity.User;
import com.example.project__4.repository.UserRepository;
import com.example.project__4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User createUser(UserRequestDto userRequestDto) {
       // if(userExits(userRequestDto.))
        return null;
    }

    @Override
    public User fetchUser(AuthenticationDto authenticationDto) {
        return null;
    }

    private boolean userExits(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
}
