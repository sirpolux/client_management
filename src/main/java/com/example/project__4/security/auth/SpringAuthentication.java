package com.example.project__4.security.auth;


import com.example.project__4.constant.ErrorCodes;
import com.example.project__4.entity.User;
import com.example.project__4.exception.CustomRuntimeException;
import com.example.project__4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpringAuthentication implements AuthenticationContract {

    UserRepository userRepository;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
 
    @Override
    public User getAuthenticatedUser(){
        Authentication authentication = getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new CustomRuntimeException(HttpStatus.FORBIDDEN, "Unauthorized", ErrorCodes.BAD_REQUEST);
        }
        String currentUserUid = authentication.getName();
        User user = (userRepository.findByUid(currentUserUid)).get();

        return user;
    }
}
