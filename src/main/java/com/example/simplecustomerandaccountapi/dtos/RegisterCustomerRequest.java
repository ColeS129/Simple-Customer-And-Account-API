package com.example.simplecustomerandaccountapi.dtos;

import lombok.Data;

@Data
public class RegisterCustomerRequest {
    private String name;
    private String email;
    private String password;
}
