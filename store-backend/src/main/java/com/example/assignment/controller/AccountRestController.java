package com.example.assignment.controller;

import com.example.assignment.common.ContextURL;
import com.example.assignment.exception.NotExistException;
import com.example.assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = ContextURL.API_URL)
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping(ContextURL.ACCOUNT_FIND_BY_USERNAME)
    public ResponseEntity<?> findByUsername(@PathVariable("username")Optional<String> str) throws NotExistException {
        String username = str.orElse("");
        return ResponseEntity.ok().body(accountService.findByUsername(username));
    }
}
