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

@Configuration
public class FirebaseInit {

    private final Environment environment;

    public FirebaseInit(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public FirebaseApp initFirebase() throws IOException {

        String firebaseUrl = environment.getProperty("firebase.url");
        String firebaseConfig = environment.getProperty("firebase.config");
        ByteArrayInputStream serviceAccountStream;
        if (firebaseConfig != null) {
            serviceAccountStream = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                .setDatabaseUrl(firebaseUrl)
                .build();

        return FirebaseApp.initializeApp(options);
        }
        return null;
    }
}
