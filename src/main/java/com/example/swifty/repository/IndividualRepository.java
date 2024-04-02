package com.example.swifty.repository;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {
    Optional<Individual> findByUserUserId(Long userId);
}
