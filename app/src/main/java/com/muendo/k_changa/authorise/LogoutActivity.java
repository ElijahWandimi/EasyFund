package com.muendo.k_changa.authorise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.muendo.k_changa.databinding.ActivityLogoutBinding;

public class LogoutActivity extends AppCompatActivity {
    ActivityLogoutBinding binding;
    FirebaseAuth logoutAuth;
    Button logoutButton;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = logoutAuth.getCurrentUser();
        if (currentUser == null) {
            startLoginActivity();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        logoutAuth = FirebaseAuth.getInstance();
        logoutButton = binding.btnLogout;

        logoutButton.setOnClickListener(v -> {
            // TODO: Logout user
            logoutAuth.signOut();
            startLoginActivity();
        });
    }

    public void logout() {
        logoutAuth.signOut();
    }

    public void startLoginActivity() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
