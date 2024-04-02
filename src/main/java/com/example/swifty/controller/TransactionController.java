package com.example.swifty.controller;

import com.example.swifty.dto.TransactionRequest;
import com.example.swifty.repository.CompanyRepository;
import com.example.swifty.repository.TransactionRepository;
import com.example.swifty.repository.UserRepository;
import com.example.swifty.service.TransactionService;
import com.example.swifty.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/transaction")
    public ResponseEntity<String> transaction(@RequestBody TransactionRequest request, HttpServletResponse response) {

        boolean transactionStatus = transactionService.handleTransaction(request);
        System.out.println(transactionStatus);

        if (transactionStatus){
            return ResponseEntity.status(HttpStatus.CREATED).body("Transaction completed");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction failed");
        }

    }
}
