package com.example.simplecustomerandaccountapi.repositories;

import com.example.simplecustomerandaccountapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
