package com.example.swifty.service.user_services;

import com.example.swifty.dto.UserDTO;
import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.CompanyRepository;
import com.example.swifty.repository.IndividualRepository;
import com.example.swifty.repository.UserRepository;
import com.example.swifty.utils.InputValidation;
import com.example.swifty.utils.RequestResult;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.swifty.dto.UserDTO.getUserDTO;

/**
 * Service class for handling user creation and authentication operations.
 * Provides methods for registering individuals and companies, as well as authenticating users.
 */

@Service
public class UserCreateService {

    private final UserRepository userRepository;
    private final IndividualRepository individualRepository;
    private final CompanyRepository companyRepository;
    private final InputValidation inputValidation = new InputValidation();

    public UserCreateService(UserRepository userRepository, IndividualRepository individualRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.individualRepository = individualRepository;
        this.companyRepository = companyRepository;
    }

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @return A RequestResult object containing the authentication status and user details if successful.
     */
    public RequestResult authenticateUser(String username, String password) {
        String validateUser = inputValidation.validateUserLoginInput(username.trim(), password.trim());

        if (validateUser.equals("Validation passed")) {

            Optional<User> getUser = userRepository.findByUsername(username);

            if (getUser.isPresent()) {
                User currentUser = getUser.get();
                Individual currentUserIndividual = currentUser.getIndividual();
                // Compare the entered password with the user's actual password (for educational purposes only)
                if (inputValidation.isCorrectPassword(currentUser, password)) {
                    UserDTO userDTO = getUserDTO(currentUser, currentUserIndividual);

                    return new RequestResult(true, "ok", userDTO);
                } else {
                    return new RequestResult(false, "invalid");
                }
            } else {
                return new RequestResult(false, "notFound");
            }
        }
        return new RequestResult(false, "badRequest");
    }

    /**
     * Registers an individual user with the provided details.
     *
     * @param user               The User object representing the individual user.
     * @param registerIndividual The Individual object representing the individual's details.
     * @return A string indicating the registration status.
     */
    @Transactional
    public String registerIndividual(User user, Individual registerIndividual) {

        String validateUser = inputValidation.validateRegisterUser(user, userRepository);
        String validationIndividual = inputValidation.validateRegisterIndividual(registerIndividual);

        if (!validateUser.equals("Validation passed")) {
            return validateUser;
        }

        if (!validationIndividual.equals("Validation passed")) {
            return validationIndividual;
        }
        //Remove whitespace
        user.hashPassword(user.getPassword().trim());
        user.setUsername(user.getUsername().trim());
        user.setEmail(user.getEmail().trim());
        //Connect user to individual
        registerIndividual.setUser(user);
        //Remove whitespace
        registerIndividual.setFirstName(registerIndividual.getFirstName().trim());
        registerIndividual.setLastName(registerIndividual.getFirstName().trim());
        registerIndividual.setBirthdate(registerIndividual.getBirthdate().trim());
        //Save to DB
        userRepository.save(user);
        individualRepository.save(registerIndividual);

        //response.setStatus(HttpServletResponse.SC_CREATED);
        return "Registered successfully";
    }

    /**
     * Registers a company user with the provided details.
     *
     * @param user    The User object representing the company user.
     * @param company The Company object representing the company's details.
     * @return A string indicating the registration status.
     */
    @Transactional
    public String registerCompany(User user, Company company) {

        String validationUser = inputValidation.validateRegisterUser(user, userRepository);
        String validationCompany = inputValidation.validateRegisterCompany(company);

        if (!validationUser.equals("Validation passed")) {
            return validationUser;
        }

        if (!validationCompany.equals("Validation passed")) {
            return validationUser;
        }

        company.setUser(user);
        userRepository.save(user);
        companyRepository.save(company);

        return "Registered successfully";
    }
}
