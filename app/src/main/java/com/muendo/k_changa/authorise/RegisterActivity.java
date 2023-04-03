package com.muendo.k_changa.authorise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.muendo.k_changa.MainActivity;
import com.muendo.k_changa.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth registerAuth;

    TextInputEditText editEmail, editPassword;
    TextView txtToLogin;
    Button btnRegister;
    ProgressBar progressBar;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = registerAuth.getCurrentUser();
        if (currentUser != null) {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerAuth = FirebaseAuth.getInstance();

        editEmail = binding.txtSignEmail;
        editPassword = binding.txtPassword;
        btnRegister = binding.btnSignup;
        txtToLogin = binding.btnToLogin;
        progressBar = binding.progressBar;

        btnRegister.setOnClickListener(v -> {
            String email = String.valueOf(editEmail.getText());
            String password = String.valueOf(editPassword.getText());
            progressBar.setVisibility(View.VISIBLE);

            if (isEmpty(email) || isEmpty(password)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }

            registerAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(this, LoginActivity.class);
                            startActivity(loginIntent);
                        } else {
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        txtToLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }

    public static boolean isEmpty(String text) {
        return TextUtils.isEmpty(text);
    }
}