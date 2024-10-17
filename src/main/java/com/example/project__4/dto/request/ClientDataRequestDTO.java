package com.example.project__4.dto.request;


import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Account Number is required")
    private String accountNumber;
    @NotEmpty(message = "Description is required")
    private String description;
}
