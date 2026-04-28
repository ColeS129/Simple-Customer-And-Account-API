package com.example.simplecustomerandaccountapi.repositories;

import com.example.simplecustomerandaccountapi.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
