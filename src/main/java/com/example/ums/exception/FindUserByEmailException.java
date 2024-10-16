package com.example.ums.exception;

public class FindUserByEmailException extends RuntimeException{

    private final String message;

    public FindUserByEmailException(String messge) {
        this.message = messge;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
