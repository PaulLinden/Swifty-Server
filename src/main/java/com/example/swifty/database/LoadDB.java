package com.example.swifty.database;

import com.example.swifty.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for preloading user data into the database using a CommandLineRunner.
 */

@Configuration
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> log.info("Preloading {}", repository.findAll());
    }
}
