package com.example.assignment.repo;

import com.example.assignment.entity.Account;
import com.example.assignment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findByAccount(Account account);
}
