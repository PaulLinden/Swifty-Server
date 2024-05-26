package com.example.swifty.repository;

import com.example.swifty.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link User} entities in the database.
 * Provides methods for finding users by username and checking for existence of users with a given username.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their username.
     * @param username The username of the user to find.
     * @return An Optional containing the user if found, or an empty Optional if not found.
     */
    Optional<User> findByUsername(String username);

    /**
     * Checks if a user with the given username exists in the database.
     * @param username The username to check for.
     * @return True if a user with the given username exists, false otherwise.
     */
    boolean existsByUsername(String username);
}
