package com.example.project__4.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientDataDto {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Account Number is required")
    private String accountNumber;
    @NotEmpty(message = "Description is required")
    private String description;
}
