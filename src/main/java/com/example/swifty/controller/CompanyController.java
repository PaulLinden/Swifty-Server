package com.example.swifty.controller;

import com.example.swifty.service.FirebaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/firebase")
public class CompanyController {

    private final FirebaseService firebaseService;

    public CompanyController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("data")
    public Object retrieveData(@RequestParam String path) {

        try {
            return firebaseService.retrieveData(path);
        } catch (Exception e) {
            return "Error retrieving data";
        }
    }
}
