package com.ms.User.controller;

import com.ms.User.models.dtos.UserRequestDTO;
import com.ms.User.models.entities.UserModel;
import com.ms.User.models.service.UserService;
import com.ms.User.producer.UserProducer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserRequestDTO data){
        UserModel user = userService.saveUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
