package com.example.swifty.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Service class for asynchronously retrieving company data from Firebase Realtime Database (RTDB).
 * This service acts as a mock for simulating API calls to retrieve company data.
 * Note: Future development is needed for more robust data retrieval and error handling.
 */
@Service
public class CompanyService {

    private final FirebaseApp firebaseApp;
    @Autowired
    public CompanyService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    /**
     * Retrieves company data from the specified path in Firebase RTDB.
     * @param path The path to the company data in RTDB.
     * @return The retrieved company data as an Object.
     */
    public Object retrieveCompanyData(String path) {
        DatabaseReference reference = FirebaseDatabase.getInstance(firebaseApp).getReference(path);
        CompletableFuture<Object> future = getCompanyFirebaseData(reference);
        return future.join();
    }

    /**
     * Asynchronously retrieves company data from Firebase RTDB using the provided reference.
     * @param reference The Firebase DatabaseReference to the company data.
     * @return A CompletableFuture that will eventually contain the retrieved company data.
     */
    @Async
    protected CompletableFuture<Object> getCompanyFirebaseData(DatabaseReference reference) {
        CompletableFuture<Object> future = new CompletableFuture<>();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                future.complete(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(new RuntimeException(databaseError.getMessage()));
            }
        });

        return future;
    }
}
