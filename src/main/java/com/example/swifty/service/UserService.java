package com.example.swifty.service;

import com.example.swifty.utils.UserType;
import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.CompanyRepository;
import com.example.swifty.repository.IndividualRepository;
import com.example.swifty.repository.UserRepository;
import com.example.swifty.utils.Regex;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final IndividualRepository individualRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, IndividualRepository individualRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.individualRepository = individualRepository;
        this.companyRepository = companyRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsernameOrEmail(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void registerUser(User newUser, Individual newIndividual) {
        newIndividual.setUser(newUser);
        userRepository.save(newUser);
        individualRepository.save(newIndividual);
    }

    @Transactional
    public void registerCompany(User newUser, Company newCompany) {
        newCompany.setUser(newUser);
        userRepository.save(newUser);
        companyRepository.save(newCompany);
    }

    @Transactional
    public String updateUserAndIndividual(Long userId, User updatedUser, Individual updatedIndividual) {
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
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

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

    public String validateUserLoginInput(String username, String password) {

        // Validate username
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty";
        }

        //Validate password
        if (password == null || password.isEmpty()) {
            return "Password cannot be empty";
        }

        return "Validation passed";
    }

    public String validateUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();

        // Validate username
        if (username.isEmpty()) {
            return "Username cannot be empty";
        } else if (!username.matches(Regex.MAX_45)) {
            return "Max 45 characters";
        }

        // Check if username is unique
        if (userRepository.existsByUsername(username)) {
            return "Username is already taken";
        }

        //Validate password
        if (password.isEmpty()) {
            return "Password cannot be empty";
        } else if (!password.matches(Regex.MAX_45)) {
            return "Max 45 characters";
        }

        //Validate email
        if (email.isEmpty()) {
            return "Email cannot be empty";
        } else if (!email.matches(Regex.EMAIL_REGEX)) {
            return "Check format";
        } else if (!email.matches(Regex.MAX_45)) {
            return "Max 45 characters";
        }

        return "Validation passed";
    }

    public String validateIndividual(Individual individual) {
        String firstName = individual.getFirstName();
        String lastName = individual.getLastName();
        String birthdate = individual.getBirthdate();

        if (firstName == null || firstName.isEmpty()) {
            return "Name can't be empty";
        } else if (!firstName.matches(Regex.LETTERS_REGEX)) {
            return "Max 45 characters";
        }

        if (lastName == null || lastName.isEmpty()) {
            return "Name can't be empty";
        } else if (!lastName.matches(Regex.LETTERS_REGEX)) {
            return "Max 45 characters";
        }

        if (!birthdate.matches(Regex.BIRTHDATE_REGEX)) {
            return "Wrong format";
        }

        return "Validation passed";
    }

    public String validateCompany(Company company) {
        String companyName = company.getCompanyName();
        String registerNumber = company.getRegisterNumber();

        if (companyName == null || companyName.isEmpty()) {
            return "Can't be empty";
        } else if (!companyName.matches(Regex.MAX_45)) {
            return "Max 45 characters";
        }

        if (registerNumber == null || registerNumber.isEmpty()) {
            return "Can't be empty";
        } else if (!companyName.matches(Regex.MAX_45)) {
            return "Max 45 characters";
        }

        return "Validation passed";
    }

    public String deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}
