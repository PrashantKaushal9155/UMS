package com.example.ums.exceptionHandler;

import com.example.ums.util.ErrorStructure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorBody> errors = ex.getAllErrors().stream().map(error -> (FieldError) error ) new ErrorBody(
                    err.getField(),
                    err.getDefaultMessage(),
                    err.getRejectedValue()
            );
        }).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorStructure.create(HttpStatus.BAD_REQUEST,"Invalid Request",errors));
    }

    private static class ErrorBody {
        String fieldname;
        String message;
        Object rejectedValue;

        public ErrorBody(String fieldname, String message, Object rejectedValue) {
            this.fieldname = fieldname;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getMessage() {
            return message;
        }

        public String getFieldname() {
            return fieldname;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }
    }
}
