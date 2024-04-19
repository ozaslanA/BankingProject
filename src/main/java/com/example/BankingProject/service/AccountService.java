package com.example.BankingProject.service;

import com.example.BankingProject.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    List<Account> searchByName(String name);

    Account getById(int id);

    Account save(Account account);

    Account delete(int id);

    List<Account> getByPriceAsc();

    List<Account> getByPriceDesc();



}