package com.example.simplecustomerandaccountapi.mappers;

import com.example.simplecustomerandaccountapi.dtos.AccountDto;
import com.example.simplecustomerandaccountapi.entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toAccountDto(Account account);
}
