package com.example.swifty.dto;

import com.example.swifty.entity.transaction_log.TransactionItems;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) class representing a transaction request.
 * Contains information about the transaction such as user ID, user email, transaction date and time,
 * and a list of transaction items.
 */

@Getter
@Setter
public class TransactionRequest {

    private Long userId;
    private String userEmail;
    private LocalDateTime dateTime;
    private List<TransactionItems> transactionItems;
}
