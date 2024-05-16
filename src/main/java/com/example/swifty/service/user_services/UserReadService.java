package com.example.swifty.service.user_services;

import com.example.swifty.entity.users.User;
import com.example.swifty.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserReadService {

    UserRepository userRepository;

    public UserReadService() {}

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsernameOrEmail(String username) {
        return userRepository.findByUsername(username);
    }
}