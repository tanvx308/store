package com.example.assignment.service;

import com.example.assignment.entity.Account;
import com.example.assignment.exception.NotExistException;

public interface AccountService {
    Account save(Account account);

    Account update(Account account);

    Account findByUsername(String username) throws NotExistException;

    void delete(Integer id);
}
