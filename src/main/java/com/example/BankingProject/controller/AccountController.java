package com.example.BankingProject.controller;

import com.example.BankingProject.dto.AccountResponse;
import com.example.BankingProject.model.Account;
import com.example.BankingProject.service.AccountService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping("/")
    public Account save( @RequestBody Account account){
        return accountService.save(account);
    }


    @GetMapping("/{id}")
    public AccountResponse find(@Positive @PathVariable int id){
        return new AccountResponse("Success",accountService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        return accountService.delete(id);

    }

    @GetMapping("/desc")
    public List<Account> getByPriceDesc(){
        return accountService.getByPriceDesc();
    }
    @GetMapping("/asc")
    public List<Account> getByPriceAsc(){
        return accountService.getByPriceAsc();
    }
    @GetMapping("/name/{name}")
    public List<Account> getByName( @PathVariable String name){
        return accountService.searchByName(name);
    }

}