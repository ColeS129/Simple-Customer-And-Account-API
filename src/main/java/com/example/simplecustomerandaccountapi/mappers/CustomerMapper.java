package com.example.simplecustomerandaccountapi.mappers;

import com.example.simplecustomerandaccountapi.dtos.CustomerDto;
import com.example.simplecustomerandaccountapi.dtos.RegisterCustomerRequest;
import com.example.simplecustomerandaccountapi.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
    Customer toEntity(RegisterCustomerRequest request);
}
