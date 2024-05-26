package com.example.swifty.service;

import com.example.swifty.dto.TransactionRequest;
import com.example.swifty.entity.transaction_log.TransactionItems;
import com.example.swifty.entity.transaction_log.Transaction;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.TransactionRepository;
import com.example.swifty.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public boolean handleTransaction(TransactionRequest request) {

        Optional<User> user = userRepository.findById(request.getUserId());

        if (user.isPresent()) {
            try {
                Transaction transaction = new Transaction();
                transaction.setCustomerId(user.get().getUserId());
                transaction.setUserEmail(user.get().getEmail());
                transaction.setDateTime(request.getDateTime());

                //Link the products to the transaction
                List<TransactionItems> transactionItemsList = new ArrayList<>();
                for (TransactionItems transactionItems : request.getTransactionItems()){
                    transactionItems.setTransaction(transaction);
                    transactionItemsList.add(transactionItems);
                }
                //Add the product list
                transaction.setTransactionItems(transactionItemsList);

                transactionRepository.save(transaction);

                return true;
            } catch (Exception e) {
                e.fillInStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
