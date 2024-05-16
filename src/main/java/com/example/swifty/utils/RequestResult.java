package com.example.swifty.utils;

import com.example.swifty.dto.UserDTO;
import lombok.Getter;

@Getter
public class RequestResult {

    private final boolean success;
    private final String message;
    private UserDTO userDTO;

    public RequestResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RequestResult(boolean success, String message, UserDTO userDTO) {
        this.success = success;
        this.message = message;
        this.userDTO = userDTO;
    }

}
