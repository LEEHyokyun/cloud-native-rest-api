package com.restapi.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundedException extends RuntimeException{
    public UserNotFoundedException(String message){
        super(message);
    }
}
