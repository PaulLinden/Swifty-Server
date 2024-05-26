package com.example.swifty.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) class representing a request to register an individual.
 * Contains parameters necessary to populate both User and Individual entities.
 */
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
