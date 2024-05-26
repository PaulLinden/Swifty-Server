package com.example.swifty.repository;

import com.example.swifty.entity.users.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link Individual} entities in the database.
 * Provides methods for finding individuals by their associated user ID.
 */

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {

    /**
     * Finds an individual by their associated user ID.
     * @param userId The ID of the user associated with the individual.
     * @return An Optional containing the individual if found, or an empty Optional if not found.
     */
    Optional<Individual> findByUserUserId(Long userId);
}
