package com.example.swifty.utils;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;

public class InputValidation {


    public String validateRegisterUser(User user, UserRepository userRepository) {
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

    public String validateRegisterIndividual(Individual individual) {
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

    public String validateRegisterCompany(Company company) {
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

    public String validateUserLoginInput(String username, String password) {

        // Validate username
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty";
        }

        //Validate password
        if (password == null || password.isEmpty() ) {
            return "Password cannot be empty";
        }

        return "Validation passed";
    }

    public boolean isCorrectPassword(User user, String password) {
        return user.checkPassword(password);
    }
}
