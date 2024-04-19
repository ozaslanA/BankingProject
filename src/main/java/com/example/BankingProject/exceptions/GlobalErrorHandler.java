package com.example.BankingProject.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<AccountErrorResponse> handleException(AccountErrorResponse exception) {
        AccountErrorResponse plantErrorResponse = new AccountErrorResponse(
                exception.getStatus(), exception.getMessage(), LocalDateTime.now()
        );
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getStatus().value());
        return new ResponseEntity<>(plantErrorResponse, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AccountErrorResponse> handleException(Exception exception) {
        AccountErrorResponse accountErrorResponse = new AccountErrorResponse(
                HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now()
        );
        log.error("EXCEPTION OCCURED: " + exception.getMessage());
        return new ResponseEntity<>(accountErrorResponse, HttpStatus.BAD_REQUEST);
    }



}
