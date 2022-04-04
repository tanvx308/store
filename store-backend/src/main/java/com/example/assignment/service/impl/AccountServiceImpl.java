package com.example.assignment.service.impl;

import com.example.assignment.entity.Account;
import com.example.assignment.exception.NotExistException;
import com.example.assignment.repo.AccountRepo;
import com.example.assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public Account findByUsername(String username) throws NotExistException {
        Account account = accountRepo.findByUsername(username);
        if(account == null){
            throw new NotExistException(400, String.format("Account with username: %s is not exist", username));
        }
        return account;
    }

    @Override
    public void delete(Integer id) {

    }
}
