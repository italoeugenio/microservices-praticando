package com.ms.Email.models.dtos;

import java.util.UUID;

public record EmailDTO(
        UUID userId,
        String to,
        String subject,
        String body

) {
}
