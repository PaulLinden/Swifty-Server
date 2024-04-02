package com.example.swifty.dto;

import com.example.swifty.entity.transaction_log.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TransactionRequest {

    private String customerName;
    private String companyName;
    private LocalDateTime dateTime;
    private List<Product> products;
}
