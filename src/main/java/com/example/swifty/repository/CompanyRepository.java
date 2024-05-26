package com.example.swifty.repository;

import com.example.swifty.entity.users.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link Company} entities in the database.
 * Provides methods for finding companies by their associated user ID.
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    /**
     * Finds a company by its associated user ID.
     * @param userId The ID of the user associated with the company.
     * @return An Optional containing the company if found, or an empty Optional if not found.
     */
    Optional<Company> findByUserUserId(Long userId);
}
