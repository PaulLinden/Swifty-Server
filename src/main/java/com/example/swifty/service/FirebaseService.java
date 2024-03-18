package com.example.swifty.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class FirebaseService {

    private final FirebaseApp firebaseApp;
    @Autowired
    public FirebaseService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }
    public Object retrieveData(String path) {
        DatabaseReference reference = FirebaseDatabase.getInstance(firebaseApp).getReference(path);
        return getData(reference);
    }
    @Async
    public CompletableFuture<Object> getData(DatabaseReference reference) {
        CompletableFuture<Object> future = new CompletableFuture<>();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                future.complete(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(new RuntimeException("Error retrieving data from Firebase: " + databaseError.getMessage()));
            }
        });

        return future;
    }
}
