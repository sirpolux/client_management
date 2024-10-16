package com.example.project__4.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDto {

    @NotNull(message = "email is required" )
    private String email;

    @NotNull(message =  "Password is required")
    private String password;
}
