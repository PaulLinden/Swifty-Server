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

    public RequestResult authenticateUser(String username, String password) {
        String validateUser = inputValidation.validateUserLoginInput(username, password);

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

    @Transactional
    public String registerIndividual(User user, Individual registerIndividual){

        String validateUser = inputValidation.validateRegisterUser(user, userRepository);
        String validationIndividual = inputValidation.validateRegisterIndividual(registerIndividual);

        if (!validateUser.equals("Validation passed")) {
            return validateUser;
        }

        if (!validationIndividual.equals("Validation passed")) {
            return validationIndividual;
        }

        user.hashPassword(user.getPassword());
        // Print the hashed password
        System.out.println("Hashed password: " + user.getPassword());
        registerIndividual.setUser(user);
        userRepository.save(user);
        individualRepository.save(registerIndividual);

       // response.setStatus(HttpServletResponse.SC_CREATED);
        return "Registered successfully";
    }

    @Transactional
    public String registerCompany(User user, Company company){

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
