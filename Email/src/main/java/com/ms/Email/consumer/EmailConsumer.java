package com.ms.Email.consumer;

import com.ms.Email.models.dtos.EmailDTO;
import com.ms.Email.models.entities.EmailModel;
import com.ms.Email.models.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        var email = new EmailModel();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
    }
}
