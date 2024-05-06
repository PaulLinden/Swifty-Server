package com.example.swifty.controller;

import com.example.swifty.dto.CompanyRegisterRequest;
import com.example.swifty.dto.IndividualRegisterRequest;
import com.example.swifty.dto.UserDTO;
import com.example.swifty.dto.UserLoginRequest;
import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;
import com.example.swifty.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static com.example.swifty.dto.UserDTO.getUserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //Root -----------------------------------------------------
    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/findById/{userId}")
    public String findUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(value -> "User found: " + value.getUsername())
                .orElse("User not found");
    }

    @GetMapping("/findByUsername/{username}")
    public String findUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsernameOrEmail(username);
        return user.map(users -> "User found: " + users.getUsername()).orElse("User not found");
    }

    //Needs to be refactored and add security!!! Vulnerable
    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
        String validateUser = userService.validateUserLoginInput(request.getUsername(), request.getPassword());
        if (validateUser.equals("Validation passed")) {

            Optional<User> user = userService.findByUsernameOrEmail(request.getUsername());

            if (user.isPresent()) {

                User currentUser = user.get();
                Individual currentUserIndividual = currentUser.getIndividual();
                // Compare the entered password with the user's actual password (for educational purposes only)
                if (request.getPassword().equals(currentUser.getPassword())) {

                    UserDTO userDTO = getUserDTO(currentUser, currentUserIndividual);

                    return ResponseEntity.ok(userDTO);
                } else {

                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
                }
            } else {
                return ResponseEntity.notFound().build(); // User not found
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");
        }
    }

    //Post methods -----------------------------------------------------------------------------
    @PostMapping("/register/individual")
    String registerIndividual(@RequestBody IndividualRegisterRequest request, HttpServletResponse response) {

        User registerUser = request.getUser();
        Individual registerIndividual = request.getIndividual();

        String validateUser = userService.validateUser(registerUser);
        String validationIndividual = userService.validateIndividual(registerIndividual);

        if (!validateUser.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validateUser;
        }

        if (!validationIndividual.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validationIndividual;
        }

        userService.registerUser(registerUser, registerIndividual);
        response.setStatus(HttpServletResponse.SC_CREATED);

        return "Registered successfully";
    }

    @PostMapping("/register/company")
    String registerCompany(@RequestBody CompanyRegisterRequest request, HttpServletResponse response) {
        User user = request.getUser();
        Company company = request.getCompany();
        //Validate username
        String validationUser = userService.validateUser(user);
        String validationCompany = userService.validateCompany(company);

        if (!validationUser.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validationUser;
        }

        if (!validationCompany.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validationUser;
        }

        userService.registerCompany(user, company);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return "Registered successfully";
    }

    //Update methods --- need additional methods for updating individual and company specifics.
    @PutMapping("/update/individual/{userId}")
    public String updateIndividualUser(@PathVariable Long userId, @RequestBody IndividualRegisterRequest request, HttpServletResponse response) {
        User updatedUser = request.getUser();
        Individual updatedIndividual = request.getIndividual();

        String validateUser = userService.validateUser(updatedUser);
        String validateIndividual = userService.validateIndividual(updatedIndividual);

        if (!Objects.equals(validateUser, "Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validateUser;
        }

        if (!Objects.equals(validateIndividual, "Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validateIndividual;
        }

        String requestMessage = userService.updateUserAndIndividual(userId, updatedUser, updatedIndividual);

        if (Objects.equals(requestMessage, "Successfully updated")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return requestMessage;
    }

    @PutMapping("/update/company/{userId}")
    public String updateCompanyUser(@PathVariable Long userId, @RequestBody CompanyRegisterRequest request, HttpServletResponse response) {
        User updatedUser = request.getUser();
        Company updatedCompany = request.getCompany();

        String validateUser = userService.validateUser(updatedUser);
        String validateCompany = userService.validateCompany(updatedCompany);

        if (!Objects.equals(validateUser, "Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validateUser;
        }

        if (!Objects.equals(validateCompany, "Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return validateCompany;
        }

        String requestMessage = userService.updateUserAndCompany(userId, updatedUser, updatedCompany);

        if (Objects.equals(requestMessage, "Successfully updated")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return requestMessage;
    }

    //Delete methods ------ Needs additional methods or branched methods that remove individuals and company
    @DeleteMapping("/remove/{userId}")
    public String deleteUser(@PathVariable Long userId, HttpServletResponse response) {
        String requestMessage = userService.deleteUser(userId);

        if (Objects.equals(requestMessage, "User not found")) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        return userService.deleteUser(userId);
    }
}
