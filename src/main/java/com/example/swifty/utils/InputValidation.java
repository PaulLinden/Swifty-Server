package com.example.swifty.utils;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;

/**
 * Utility class for validating user input during registration and login.
 */
public class InputValidation {

    /**
     * Validates user registration input.
     * @param user           The User object to validate.
     * @param userRepository The UserRepository for checking username uniqueness.
     * @return "Validation passed" if valid, otherwise an error message.
     */
    public String validateRegisterUser(User user, UserRepository userRepository) {
        String username = user.getUsername().trim();
        String password = user.getPassword().trim();
        String email = user.getEmail().trim();

        // Validate username
        if (username.isEmpty()) {
            return "Username cannot be empty";
        } else if (!username.matches(Regex.MAX_100)) {
            return "Max 45 characters";
        }

        // Check if the username is unique
        if (userRepository.existsByUsername(username)) {
            return "Username is already taken";
        }

        //Validate password
        if (password.isEmpty()) {
            return "Password cannot be empty";
        } else if (!password.matches(Regex.MAX_100)) {
            return "Max 45 characters";
        }

        //Validate email
        if (email.isEmpty()) {
            return "Email cannot be empty";
        } else if (!email.matches(Regex.EMAIL_REGEX)) {
            return "Check format";
        } else if (!email.matches(Regex.MAX_100)) {
            return "Max 45 characters";
        }

        return "Validation passed";
    }

    /**
     * Validates individual registration input.
     * @param individual The Individual object to validate.
     * @return "Validation passed" if valid, otherwise an error message.
     */
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

    /**
     * Validates company registration input.
     * @param company The Company object to validate.
     * @return "Validation passed" if valid, otherwise an error message.
     */
    public String validateRegisterCompany(Company company) {
        String companyName = company.getCompanyName();
        String registerNumber = company.getRegisterNumber();

        if (companyName == null || companyName.isEmpty()) {
            return "Can't be empty";
        } else if (!companyName.matches(Regex.MAX_100)) {
            return "Max 45 characters";
        }

        if (registerNumber == null || registerNumber.isEmpty()) {
            return "Can't be empty";
        } else if (!companyName.matches(Regex.MAX_100)) {
            return "Max 45 characters";
        }

        return "Validation passed";
    }

    /**
     * Validates user login input.
     * @param username The username to validate.
     * @param password The password to validate.
     * @return "Validation passed" if valid, otherwise an error message.
     */
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

    /**
     * Checks if the provided password matches the hashed password of the user.
     * @param user     The User object to check the password against.
     * @param password The password to check.
     * @return True if the passwords match, false otherwise.
     */
    public boolean isCorrectPassword(User user, String password) {
        return user.checkPassword(password);
    }
}
