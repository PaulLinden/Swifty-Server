package com.example.swifty.controller;

import com.example.swifty.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Controller class for handling company-related requests.
 */
@RestController
@RequestMapping("/api/firebase")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Endpoint for retrieving company data based on the provided path.
     * @param path The path parameter specifying the data to retrieve.
     * @return ResponseEntity containing the retrieved company data or error message.
     */
    @GetMapping("data")
    private ResponseEntity<Object> getCompanyData(@RequestParam String path) {

        try {
            if (!Objects.equals(path, "companies")){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check your path.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(companyService.retrieveCompanyData(path));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving data.");
        }
    }
}
