package com.example.project__4.security.auth;


import com.example.project__4.entity.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationContract {
    Authentication getAuthentication();
    User getAuthenticatedUser();
}
