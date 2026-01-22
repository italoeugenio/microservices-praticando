package com.ms.Email.models.service;

import com.ms.Email.models.dtos.EmailDTO;
import com.ms.Email.models.entities.EmailModel;
import com.ms.Email.enums.EmailStatus;
import com.ms.Email.models.repositories.EmailRepository;
import com.ms.Email.models.service.email.interfaces.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private final EmailRepository emailRepository;
    @Autowired
    private final EmailSenderService emailSenderService;

    public EmailService(EmailRepository emailRepository, EmailSenderService emailSenderService) {
        this.emailRepository = emailRepository;
        this.emailSenderService = emailSenderService;
    }

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try {
            EmailDTO emailDto = new EmailDTO(
                    emailModel.getUserId(),
                    emailModel.getEmailTo(),
                    emailModel.getSubject(),
                    emailModel.getBody()
            );
            emailSenderService.sendEmail(emailDto);
            emailModel.setEmailStatus(EmailStatus.SENT);
        } catch (Exception e) {
            emailModel.setEmailStatus(EmailStatus.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}