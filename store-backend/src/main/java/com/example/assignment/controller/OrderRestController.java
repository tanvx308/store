package com.example.assignment.controller;

import com.example.assignment.common.ContextURL;
import com.example.assignment.dto.FormOrderDto;
import com.example.assignment.entity.Order;
import com.example.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = ContextURL.API_URL)
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping(ContextURL.ORDER_SAVE)
    public ResponseEntity<?> createOrder(@RequestBody FormOrderDto dto){
        Order order = dto.transfer();
        return ResponseEntity.ok().body(orderService.save(order));
    }
}
