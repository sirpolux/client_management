package com.example.project__4.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private  String email;
    private String firstname;
    private String lastnane;
    private String password;
    private String confirmPassword;
}
