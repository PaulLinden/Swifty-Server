package com.example.swifty.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a user login request.
 * Contains the username and password fields for user authentication.
 */

@Getter
@Setter
public class UserLoginRequest {
    private String username;
    private String password;
}
