package com.ms.User.producer;

import com.ms.User.models.dtos.EmailDTO;
import com.ms.User.models.entities.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        EmailDTO emailDto = new EmailDTO(
                userModel.getId(),
                userModel.getEmail(),
                "Cadastro realizado com sucesso!",
                userModel.getFullName() + ", seja bem vindo(a)!\n" +
                        "Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
