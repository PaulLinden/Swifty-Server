package com.example.swifty.controller;

import com.example.swifty.service.FirebaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/firebase")
public class FirebaseController {

    private final FirebaseService firebaseService;

    public FirebaseController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("data")
    public Object retrieveData(@RequestParam String path) {
        System.out.println("API HÄR!!!!!!!");
        try {
            System.out.println("DATA HÄR!!!!!!!");
            return firebaseService.retrieveData(path);
        } catch (Exception e) {
            System.out.println("ERRRROROROROROROOROROR");
            return "Error retrieving data";
        }
    }
}
