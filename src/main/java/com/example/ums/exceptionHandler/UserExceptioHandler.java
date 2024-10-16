package com.example.ums.exceptionHandler;

import com.example.ums.exception.FindUserByEmailException;
import com.example.ums.exception.FindUserByIdException;
import com.example.ums.util.AppResponseBuilder;
import com.example.ums.util.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptioHandler {
    private final AppResponseBuilder builder;

    public UserExceptioHandler(AppResponseBuilder builder) {
        this.builder = builder;
    }

    @ExceptionHandler(FindUserByIdException.class)
    public ResponseEntity<ErrorStructure> handleUserNotFoundById(FindUserByIdException ex){
        return builder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"User not found by Id");
    }
    @ExceptionHandler(FindUserByEmailException.class)
    public ResponseEntity<ErrorStructure> handleUserNotFoundByEmail(FindUserByEmailException ex){

        return builder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"User not found by email");
    }
}
