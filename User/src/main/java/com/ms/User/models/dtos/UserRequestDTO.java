package com.ms.User.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Fullname is required")
        String fullName,

        @NotBlank
        @Email(message = "Enter a valid email")
        String email
) {
}
