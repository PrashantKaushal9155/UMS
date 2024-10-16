package com.example.ums.util;

import com.example.ums.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder {

    public ResponseEntity<ErrorStructure> error(HttpStatus status, String message, String rootCause){
        return ResponseEntity
                .status(status)
                .body(ErrorStructure.create(status, message, rootCause));
    }
    public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data){
        return ResponseEntity
                .status(status)
                .body(ResponseStructure.create(status,message,data));
    }
}
