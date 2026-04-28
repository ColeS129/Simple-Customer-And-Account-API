package com.example.simplecustomerandaccountapi.repositories;

import com.example.simplecustomerandaccountapi.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCustomerId(Long customerId);
}
