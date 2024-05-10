package com.example.swifty.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/*
* This is the service layer for the company data retrieval.
* Since the data is fetched async from RTDB.
* Note! that the data is only a mock for simulating
* an API call from the companies. This will need a lot of
* further development in the future.
*/
@Service
public class CompanyService {

    private final FirebaseApp firebaseApp;
    @Autowired
    public CompanyService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }
    //Method for retrieving data for response
    public Object retrieveCompanyData(String path) {
        DatabaseReference reference = FirebaseDatabase.getInstance(firebaseApp).getReference(path);
        CompletableFuture<Object> future = getCompanyFirebaseData(reference);
        return future.join();
    }
    //Async operation for getting data from Firebase - RTDB.
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
