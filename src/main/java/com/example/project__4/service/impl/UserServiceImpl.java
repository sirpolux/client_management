package com.example.project__4.service.impl;

import com.example.project__4.dto.request.AuthenticationDto;
import com.example.project__4.dto.request.UserRequestDto;
import com.example.project__4.entity.User;
import com.example.project__4.exception.InvalidUserCredentialException;
import com.example.project__4.exception.UserAlredyExistsException;
import com.example.project__4.repository.UserRepository;
import com.example.project__4.service.UserService;
import com.example.project__4.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final  Utility utility;


    @Override
    public User fetchUser(AuthenticationDto authenticationDto) {
        if(!userExits(authenticationDto.getEmail())){
            throw new InvalidUserCredentialException("User with  credential not found! Invalid username or password");
        }
        return (User) utility.unwrapOptional(userRepository.findByEmail(authenticationDto.getEmail()), "user");

    }
    @Override
    public boolean userExits(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
}
