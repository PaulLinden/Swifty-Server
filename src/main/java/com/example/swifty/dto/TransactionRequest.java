package com.example.swifty.dto;

import com.example.swifty.entity.transaction_log.cartItems;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TransactionRequest {

    private Long userId;
    private String userEmail;
    private Long companyId;
    private LocalDateTime dateTime;
    private List<cartItems> cartItems;
}
