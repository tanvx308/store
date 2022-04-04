package com.example.assignment.service;

import com.example.assignment.entity.Account;
import com.example.assignment.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    List<Order> findByAccount(Account account);
}
