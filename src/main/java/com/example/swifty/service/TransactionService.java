package com.example.swifty.service;

import com.example.swifty.dto.TransactionRequest;
import com.example.swifty.entity.transaction_log.cartItems;
import com.example.swifty.entity.transaction_log.Transaction;
import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.CompanyRepository;
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
    private final CompanyRepository companyRepository;
    private final TransactionRepository transactionRepository;
    public TransactionService(UserRepository userRepository, CompanyRepository companyRepository, TransactionRepository transactionRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public boolean handleTransaction(TransactionRequest request) {

        Optional<Company> company = companyRepository.findById(request.getCompanyId());
        Optional<User> user = userRepository.findById(request.getUserId());

        if (company.isPresent() && user.isPresent()) {
            try {
                Transaction transaction = new Transaction();
                transaction.setCustomerId(user.get().getUserId());
                transaction.setUserEmail(user.get().getEmail());
                transaction.setCompanyId(company.get().getCompanyId());
                transaction.setDateTime(request.getDateTime());

                //Link the products to the transaction
                List<cartItems> cartItemsList = new ArrayList<>();
                for (cartItems cartItems : request.getCartItems()){
                    cartItems.setTransaction(transaction);
                    cartItemsList.add(cartItems);
                }
                //Add the product list
                transaction.setCartItems(cartItemsList);

                transactionRepository.save(transaction);

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
