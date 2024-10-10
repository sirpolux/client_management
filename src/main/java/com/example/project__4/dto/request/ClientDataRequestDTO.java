package com.example.project__4.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDataRequestDTO {
    private String customerId;
    private String name;
    private String accountNumber;
}
