package com.ms.User.handler;

import com.ms.User.exception.user.UserAlreadyRegistered;
import com.ms.User.exception.user.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyRegistered.class)
    public ResponseEntity<String> handleUserAlreadyRegistered(UserAlreadyRegistered exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

}
