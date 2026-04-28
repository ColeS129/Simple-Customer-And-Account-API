package com.example.simplecustomerandaccountapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
}
