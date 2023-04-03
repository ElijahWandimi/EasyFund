package com.muendo.k_changa.authorise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.muendo.k_changa.DashActivity;
import com.muendo.k_changa.MainActivity;
import com.muendo.k_changa.databinding.ActivityLoginBinding;
import com.muendo.k_changa.ui.create_event.CreateEventActivity;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth loginAuth;
    TextInputEditText editEmail, editPassword;
    Button btnLogin;
    TextView txtToRegister;
    ProgressBar progressBar;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = loginAuth.getCurrentUser();
        if (currentUser != null) {
            Intent mainIntent = new Intent(getApplicationContext(), DashActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginAuth = FirebaseAuth.getInstance();

        editEmail = binding.txtLogEmail;
        editPassword = binding.txtPassword;
        btnLogin = binding.btnLogin;
        txtToRegister = binding.btnToSignUp;
        progressBar = binding.progressBar;

        btnLogin.setOnClickListener(v -> {
            String email = String.valueOf(editEmail.getText());
            String password = String.valueOf(editPassword.getText());
            progressBar.setVisibility(View.VISIBLE);

            if (RegisterActivity.isEmpty(email) || RegisterActivity.isEmpty(password)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
            loginAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(getApplicationContext(), DashActivity.class);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        txtToRegister.setOnClickListener(v -> {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }
}