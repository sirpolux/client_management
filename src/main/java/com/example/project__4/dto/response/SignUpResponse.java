package com.example.project__4.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUpResponse {
    private String email;
    private String token;
    private Date expiresAt;
}
