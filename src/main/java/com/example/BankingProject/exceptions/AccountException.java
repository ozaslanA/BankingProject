package com.example.BankingProject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@Data
public class AccountException extends  RuntimeException{
    private HttpStatus status;


    public AccountException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
