package com.example.swifty.dto;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRegisterRequest {
    User user;
    Company company;
}
