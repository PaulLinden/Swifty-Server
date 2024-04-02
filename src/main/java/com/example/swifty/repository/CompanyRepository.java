package com.example.swifty.repository;

import com.example.swifty.entity.users.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUserUserId(Long userId);

    Optional<Company> findByCompanyName(String companyName);

}
