package com.example.swifty.controller;

import com.example.swifty.dto.CompanyRegisterRequest;
import com.example.swifty.dto.IndividualRegisterRequest;
import com.example.swifty.dto.UserLoginRequest;
import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import com.example.swifty.service.user_services.UserCreateService;
import com.example.swifty.service.user_services.UserDeleteService;
import com.example.swifty.service.user_services.UserReadService;
import com.example.swifty.service.user_services.UserUpdateService;
import com.example.swifty.utils.RequestResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

/*
 * Endpoints for user operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserReadService userReadService;
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;


    public UserController(UserReadService userReadService, UserCreateService userCreateService, UserUpdateService userUpdateService, UserDeleteService userDeleteService) {
        this.userReadService = userReadService;
        this.userCreateService = userCreateService;
        this.userUpdateService = userUpdateService;
        this.userDeleteService = userDeleteService;
    }

    //Root -----------------------------------------------------
    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userReadService.getAllUsers();
    }

    @GetMapping("/findById/{userId}")
    public String findUserById(@PathVariable Long userId) {
        Optional<User> user = userReadService.getUserById(userId);
        return user.map(value -> "User found: " + value.getUsername())
                .orElse("User not found");
    }

    @GetMapping("/findByUsername/{username}")
    public String findUserByUsername(@PathVariable String username) {
        Optional<User> user = userReadService.getUserByUsernameOrEmail(username);
        return user.map(users -> "User found: " + users.getUsername()).orElse("User not found");
    }

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {

        RequestResult requestResult = userCreateService.authenticateUser(request.getUsername(), request.getPassword());

        if (requestResult.isSuccess()) {
            return ResponseEntity.ok(requestResult.getUserDTO());
        } else {

            if (Objects.equals(requestResult.getMessage(), "invalid")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            } else if (Objects.equals(requestResult.getMessage(), "badRequest")) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    //Post methods -----------------------------------------------------------------------------
    @PostMapping("/register/individual")
    String registerIndividual(@RequestBody IndividualRegisterRequest request, HttpServletResponse response) {

        User registerUser = request.getUser();
        Individual registerIndividual = request.getIndividual();

        String registrationStatus =userCreateService.registerIndividual(registerUser, registerIndividual);

        if (registrationStatus.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }else{
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        return registrationStatus;
    }

    @PostMapping("/register/company")
    String registerCompany(@RequestBody CompanyRegisterRequest request, HttpServletResponse response) {
        User user = request.getUser();
        Company company = request.getCompany();

        String registerStatus = userCreateService.registerCompany(user, company);

        if (!registerStatus.equals("Validation passed")) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }else {
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        return registerStatus;
    }

    //Update methods --- need additional methods for updating individual and company specifics.
    @PutMapping("/update/individual/{userId}")
    public String updateIndividualUser(@PathVariable Long userId, @RequestBody IndividualRegisterRequest request, HttpServletResponse response) {
        User updatedUser = request.getUser();
        Individual updatedIndividual = request.getIndividual();

        String updateStatus = userUpdateService.updateUserAndIndividual(userId, updatedUser, updatedIndividual);

        if (Objects.equals(updateStatus, "Successfully updated")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return updateStatus;
    }

    @PutMapping("/update/company/{userId}")
    public String updateCompanyUser(@PathVariable Long userId, @RequestBody CompanyRegisterRequest request, HttpServletResponse response) {
        User updatedUser = request.getUser();
        Company updatedCompany = request.getCompany();

        String updateStatus = userUpdateService.updateUserAndCompany(userId, updatedUser, updatedCompany);

        if (Objects.equals(updateStatus, "Successfully updated")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return updateStatus;
    }

    //Delete methods ------ Needs further work so that it also removes individual/company that has relation.
    @DeleteMapping("/remove/{userId}")
    public String deleteUser(@PathVariable Long userId, HttpServletResponse response) {
        String requestMessage = userDeleteService.deleteUser(userId);

        if (Objects.equals(requestMessage, "User not found")) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        return requestMessage;
    }
}
