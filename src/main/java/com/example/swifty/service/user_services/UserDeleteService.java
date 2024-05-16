package com.example.swifty.service.user_services;

import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeleteService {

    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
