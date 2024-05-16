package com.example.swifty.controller;

import com.example.swifty.dto.TransactionRequest;
import com.example.swifty.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/*
* Endpoint for transactions.
*/
@Controller
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> transaction(@RequestBody TransactionRequest request) {

        boolean transactionStatus = transactionService.handleTransaction(request);

        if (transactionStatus){
            return ResponseEntity.status(HttpStatus.CREATED).body("Transaction completed");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction failed");
        }

    }
}
