package com.example.swifty.dto;

import lombok.Getter;
import lombok.Setter;
/*
* Has the needed params to register an individual.
* This means that this request will populate both
* User and Individual entity
* */
@Getter
@Setter
public class IndividualRegisterRequest {
    private Long id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String password;
}
