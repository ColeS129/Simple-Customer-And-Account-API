package com.example.simplecustomerandaccountapi.controllers;

import com.example.simplecustomerandaccountapi.dtos.CustomerDto;
import com.example.simplecustomerandaccountapi.dtos.RegisterCustomerRequest;
import com.example.simplecustomerandaccountapi.mappers.CustomerMapper;
import com.example.simplecustomerandaccountapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        var customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(
            @RequestBody RegisterCustomerRequest request,
            UriComponentsBuilder uriBuilder) {
        var customer = customerMapper.toEntity(request);
        customer = customerRepository.save(customer);

        var customerDto = customerMapper.toCustomerDto(customer);
        var uri = uriBuilder.path("/customers/{id}").build(customer.getId());
        return ResponseEntity.created(uri).body(customerDto);
    }
}
