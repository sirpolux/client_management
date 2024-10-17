package com.example.project__4.dto.request;

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
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Account Number is required")
    private String accountNumber;
    @NotNull(message = "Description is required")
    private String description;
}
