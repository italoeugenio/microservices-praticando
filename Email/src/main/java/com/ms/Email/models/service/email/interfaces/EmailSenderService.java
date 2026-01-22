package com.ms.Email.models.service.email.interfaces;

import com.ms.Email.models.dtos.EmailDTO;

public interface EmailSenderService {
    void sendEmail(EmailDTO emailDTO);
}
