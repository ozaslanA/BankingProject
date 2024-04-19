package com.example.BankingProject.dao;

import com.example.BankingProject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDao extends JpaRepository<Account,Integer> {


    @Query("SELECT a FROM Account a WHERE LOWER(a.name) LIKE LOWER(concat('%', :name, '%'))")
    List<Account> searchByName(String name);
    @Query("SELECT a FROM Account a ORDER BY a.price ASC")
    List<Account> getByPriceAsc();

    @Query("SELECT a FROM Account a ORDER BY a.price DESC")
    List<Account> getByPriceDesc();
}


