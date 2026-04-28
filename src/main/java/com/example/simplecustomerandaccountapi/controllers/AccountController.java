package com.example.simplecustomerandaccountapi.controllers;

import com.example.simplecustomerandaccountapi.dtos.AccountDto;
import com.example.simplecustomerandaccountapi.mappers.AccountMapper;
import com.example.simplecustomerandaccountapi.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private AccountMapper accountMapper;
    private AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll()
                .stream()
                .map(accountMapper::toAccountDto)
                .toList());
    }
}
