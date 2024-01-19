package com.example.swifty.repository;

import com.example.swifty.entity.users.Company;
import com.example.swifty.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUserUserId(Long userId);
}
