package com.ms.User.models.service;

import com.ms.User.exception.user.UserAlreadyRegistered;
import com.ms.User.models.dtos.UserRequestDTO;
import com.ms.User.models.entities.UserModel;
import com.ms.User.models.repository.UserRepository;
import com.ms.User.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel saveUser(UserRequestDTO data) {
        if(userRepository.findByEmail(data.email().toLowerCase()) != null){
            throw new UserAlreadyRegistered("User alredy registered");
        }
        UserModel user = new UserModel(data);
        var newUser = userRepository.save(user);
        userProducer.publishMessageEmail(newUser);
        return newUser;
    }
}
