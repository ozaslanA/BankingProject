package com.example.BankingProject.dto;

import com.example.BankingProject.model.Account;

public record AccountResponse(String message, Account account) {
}