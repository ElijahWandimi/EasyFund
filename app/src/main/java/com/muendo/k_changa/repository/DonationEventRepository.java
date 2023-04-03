package com.muendo.k_changa.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muendo.k_changa.model.DonationEvent;

public class DonationEventRepository {
    String DATABASE_READ_ERROR;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference eventRef = database.getReference("donation-event");

    public void saveDonationEvent(String title, String description, int payBillNumber, Long targetAmount) {
        DonationEvent event = new DonationEvent(title, description, payBillNumber, targetAmount);
        eventRef.child("oneEvent").setValue(event);
    }

    public DonationEvent getDonationEvent() {
        DonationEvent[] events = new DonationEvent[1];
        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                events[0] = snapshot.getValue(DonationEvent.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DATABASE_READ_ERROR = error.getMessage();
            }
        });
        return events[0];
    }
}
