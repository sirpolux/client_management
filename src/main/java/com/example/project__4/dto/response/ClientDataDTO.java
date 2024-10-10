package com.example.project__4.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDataDTO {
    private  String uid;
    private String customerId;
    private String name;
    private String accountNumber;
}
