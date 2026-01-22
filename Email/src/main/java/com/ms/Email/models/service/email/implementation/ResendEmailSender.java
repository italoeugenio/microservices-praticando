package com.ms.Email.models.service.email.implementation;

import com.ms.Email.models.dtos.EmailDTO;
import com.ms.Email.models.service.email.interfaces.EmailSenderService;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResendEmailSender implements EmailSenderService {
    @Value("${api.security.resend.token}")
    private String secret;

    @Value("${api.security.resend.email}")
    private String email;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        Resend resend = new Resend(secret);

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from(email)
                .to(emailDTO.to())
                .subject(emailDTO.subject())
                .html(emailDTO.body())
                .build();
        try {
            CreateEmailResponse data = resend.emails().send(params);
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
