package com.example.swifty.dto;

import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualRegisterRequest {
    User user;
    Individual individual;
}
