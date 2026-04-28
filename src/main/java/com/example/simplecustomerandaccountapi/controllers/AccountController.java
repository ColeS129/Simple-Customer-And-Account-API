package com.example.simplecustomerandaccountapi.controllers;

import com.example.simplecustomerandaccountapi.dtos.AccountDto;
import com.example.simplecustomerandaccountapi.entities.Account;
import com.example.simplecustomerandaccountapi.mappers.AccountMapper;
import com.example.simplecustomerandaccountapi.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{customerId}")
    public ResponseEntity<List<AccountDto>> getAccountsByCustomer(@PathVariable Long customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        if (!accounts.isEmpty()) {
            return ResponseEntity.ok(accounts.stream()
                    .map(accountMapper::toAccountDto)
                    .toList());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
