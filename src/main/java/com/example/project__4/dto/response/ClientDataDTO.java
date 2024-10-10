package com.example.project__4.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDataDTO {
    private  String uid;
    private String customerId;
    private String name;
    private String accountNumber;
}
