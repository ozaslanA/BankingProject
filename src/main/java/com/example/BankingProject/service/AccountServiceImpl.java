package com.example.BankingProject.service;

import com.example.BankingProject.dao.AccountDao;
import com.example.BankingProject.exceptions.AccountException;
import com.example.BankingProject.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

   private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public List<Account> searchByName(String name) {
        return accountDao.searchByName(name);
    }


    @Override
    public Account getById(int id) {
        Optional<Account> accountOptional = accountDao.findById(id);
        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        throw new AccountException("Account with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }



    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account delete(int id) {
        Account accountDelete=getById(id);
        if(accountDelete != null){
            accountDao.delete(accountDelete);
        }
        return accountDelete;
    }

    @Override
    public List<Account> getByPriceAsc() {
        return accountDao.getByPriceAsc();
    }

    @Override
    public List<Account> getByPriceDesc() {
        return accountDao.getByPriceDesc();
    }


}
