package com.example.simplecustomerandaccountapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountDto {
    private Long id;
    private Double balance;
    private String type;
    private Long customerId;
}
