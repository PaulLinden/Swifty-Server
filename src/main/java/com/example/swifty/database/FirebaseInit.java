package com.example.swifty.database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Configuration class for initializing FirebaseApp with the provided configuration properties.
 */

@Configuration
public class FirebaseInit {

    private final Environment environment;

    public FirebaseInit(Environment environment) {
        this.environment = environment;
    }

    /**
     * Initialize FirebaseApp bean with Firebase configuration.
     * @return FirebaseApp object initialized with the provided configuration.
     * @throws IOException if an I/O error occurs.
     */
    @Bean
    public FirebaseApp initFirebase() throws IOException {

        String firebaseUrl = environment.getProperty("firebase.url");
        String firebaseConfig = environment.getProperty("firebase.config");
        ByteArrayInputStream serviceAccountStream;
        // Check if Firebase configuration is provided
        if (firebaseConfig != null) {
            serviceAccountStream = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));
            // Build FirebaseOptions with the provided configuration
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                    .setDatabaseUrl(firebaseUrl)
                    .build();
            // Initialize FirebaseApp with the FirebaseOptions
            return FirebaseApp.initializeApp(options);
        }
        // Return null if Firebase configuration is not provided
        return null;
    }
}
