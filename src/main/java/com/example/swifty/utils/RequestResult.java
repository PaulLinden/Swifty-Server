package com.example.swifty.utils;

import com.example.swifty.dto.UserDTO;
import lombok.Getter;

/**
 * Class representing the result of a request operation, indicating success or failure
 * and providing additional information like a message and optionally a UserDTO object.
 */
@Getter
public class RequestResult {

    private final boolean success;
    private final String message;
    private UserDTO userDTO;

    /**
     * Constructor for creating a RequestResult without a UserDTO object.
     * @param success Indicates whether the request was successful.
     * @param message A message describing the result of the request.
     */
    public RequestResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * Constructor for creating a RequestResult with a UserDTO object.
     * @param success Indicates whether the request was successful.
     * @param message A message describing the result of the request.
     * @param userDTO The UserDTO object containing user information.
     */
    public RequestResult(boolean success, String message, UserDTO userDTO) {
        this.success = success;
        this.message = message;
        this.userDTO = userDTO;
    }

}
