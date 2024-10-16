package com.example.ums.exception;

public class FindUserByIdException extends RuntimeException {
    private final String message;

    public FindUserByIdException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
