package com.example.swifty.service.user_services;

import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling user read operations.
 * Provides methods for retrieving users by ID, username, or email, as well as retrieving all users.
 */
@Service
public class UserReadService {

    private final UserRepository userRepository;

    public UserReadService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the database.
     * @return An iterable collection of all User entities.
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return An Optional containing the User entity if found, or an empty Optional if not found.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieves a user by their username.
     * @param username The username of the user to retrieve.
     * @return An Optional containing the User entity if found, or an empty Optional if not found.
     */
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}