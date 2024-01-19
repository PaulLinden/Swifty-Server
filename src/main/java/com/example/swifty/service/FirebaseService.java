package com.example.swifty.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    private final FirebaseApp firebaseApp;
    @Autowired
    public FirebaseService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }
    public Object retrieveData(String path) {
        System.out.println("BLALALALALLA");
        DatabaseReference reference = FirebaseDatabase.getInstance(firebaseApp).getReference(path);
        return getData(reference);
    }
    private Object getData(DatabaseReference reference) {
        final Object[] result = new Object[1];
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                result[0] = dataSnapshot.getValue();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException("Error retrieving data from Firebase: " + databaseError.getMessage());
            }
        });
        // Waiting for the asynchronous operation to complete (not recommended in production)
        try {
            Thread.sleep(2000); // Adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result[0];
    }
}
