package com.example.swifty.service.user_services;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.CompanyRepository;
import com.example.swifty.repository.IndividualRepository;
import com.example.swifty.repository.UserRepository;
import com.example.swifty.utils.InputValidation;
import com.example.swifty.utils.UserType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserUpdateService {

    private final UserRepository userRepository;
    private final IndividualRepository individualRepository;
    private final CompanyRepository companyRepository;
    private final InputValidation inputValidation = new InputValidation();

    public UserUpdateService(UserRepository userRepository, IndividualRepository individualRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.individualRepository = individualRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public String updateUserAndIndividual(Long userId, User updatedUser, Individual updatedIndividual) {
        String validationUser = inputValidation.validateRegisterUser(updatedUser, userRepository);
        String validationCompany = inputValidation.validateRegisterIndividual(updatedIndividual);

        if (!validationUser.equals("Validation passed")) {
            return validationUser;
        }

        if (!validationCompany.equals("Validation passed")) {
            return validationUser;
        }

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update common properties
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // Check if the user is an individual
            if (existingUser.getUserType().equals(UserType.INDIVIDUAL)) {
                // Update individual-specific fields
                Individual individual = individualRepository.findByUserUserId(userId)
                        .orElseThrow(() -> new IllegalArgumentException("Individual not found for user ID: " + userId));
                individual.setFirstName(updatedIndividual.getFirstName());
                individual.setLastName(updatedIndividual.getLastName());
                individual.setBirthdate(updatedIndividual.getBirthdate());
                // Save the updated individual back to the database
                individualRepository.save(individual);
            }
            userRepository.save(existingUser);
            // Save the updated user back to the database
            return "Successfully updated";
        } else {
            return "User not found";
        }
    }

    @Transactional
    public String updateUserAndCompany(Long userId, User updatedUser, Company updatedCompany) {
        String validationUser = inputValidation.validateRegisterUser(updatedUser, userRepository);
        String validationCompany = inputValidation.validateRegisterCompany(updatedCompany);

        if (!validationUser.equals("Validation passed")) {
            return validationUser;
        }

        if (!validationCompany.equals("Validation passed")) {
            return validationUser;
        }

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            updatedUser.hashPassword(updatedUser.getPassword());
            // Update common properties
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // Check if the user is an individual
            if (existingUser.getUserType().equals(UserType.COMPANY)) {
                // Update individual-specific fields
                Company company = companyRepository.findByUserUserId(userId)
                        .orElseThrow(() -> new IllegalArgumentException("Individual not found for user ID: " + userId));
                company.setCompanyName(updatedCompany.getCompanyName());
                company.setRegisterNumber(updatedCompany.getRegisterNumber());

                // Save the updated individual back to the database
                companyRepository.save(company);
            }
            userRepository.save(existingUser);
            // Save the updated user back to the database
            return "Successfully updated";
        } else {
            return "User not found";
        }
    }

}
