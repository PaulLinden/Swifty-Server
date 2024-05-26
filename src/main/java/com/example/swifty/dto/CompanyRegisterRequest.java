package com.example.swifty.dto;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a request to register a company.
 * Contains a User object and a Company object for registration.
 */

@Getter
@Setter
public class CompanyRegisterRequest {
    User user;
    Company company;
}
