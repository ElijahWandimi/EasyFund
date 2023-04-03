package com.muendo.k_changa.repository;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.muendo.k_changa.model.Contributor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ContributorRepository {
    String DATABASE_READ_ERROR;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference contribRef = database.getReference("contributors");

    public void saveContributor(String userName,int contribution) {
        Contributor contributor = new Contributor(userName, contribution);
        contribRef.child("oneContrib").setValue(contributor);
    }

    public void updateContributor(String userName,int contribution) {
        // TODO: fetch data from m-pesa and update the contribution
        Contributor contributor = new Contributor(userName, contribution);
        contribRef.child("oneContrib").setValue(contributor);
    }

    public ContributorDao getContributor() {
        final ContributorDao[] contributor = new ContributorDao[1];
        contribRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contributor[0] = snapshot.getValue(ContributorDao.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DATABASE_READ_ERROR = error.getMessage();
            }
        });
        return contributor[0];
    }

    public List<Contributor> getContributors() {
        ContributorDao[] contributors = new ContributorDao[Objects.requireNonNull(contribRef.getKey()).length()];
        for (int i = 0; i < contributors.length; i++) {
            contributors[i] = getContributor();
        }
        Contributor[] contributors1 = new Contributor[contributors.length];
        for (int i = 0; i < contributors.length; i++) {
            contributors1[i] = new Contributor(contributors[i].getName(), contributors[i].getContributions());
        }
        return List.of(contributors1);
    }
}
