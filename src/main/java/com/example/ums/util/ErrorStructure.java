package com.example.ums.util;

import org.springframework.http.HttpStatus;

public class ErrorStructure<T> {

    private String message;
    private T rootCause;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRootCause() {
        return rootCause;
    }

    public void setRootCause(T rootCause) {
        this.rootCause = rootCause;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static ErrorStructure<String> create(HttpStatus status, String message, String rootCause){
        ErrorStructure<String> errorStructure = new ErrorStructure<>();
        errorStructure.setMessage(message);
        errorStructure.setRootCause(rootCause);
        errorStructure.setStatus(status.value());
        return errorStructure;
    }
}
