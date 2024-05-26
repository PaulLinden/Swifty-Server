package com.example.swifty.service.user_services;

import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling user deletion operations.
 */

@Service
public class UserDeleteService {

    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Deletes a user by their ID.
     * @param userId The ID of the user to delete.
     * @return A message indicating whether the user was deleted successfully or not found.
     */
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
