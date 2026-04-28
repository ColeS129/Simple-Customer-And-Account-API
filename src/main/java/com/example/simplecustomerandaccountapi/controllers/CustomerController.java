package com.example.simplecustomerandaccountapi.controllers;

import com.example.simplecustomerandaccountapi.dtos.CustomerDto;
import com.example.simplecustomerandaccountapi.mappers.CustomerMapper;
import com.example.simplecustomerandaccountapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerDto)
                .toList());
    }
}
