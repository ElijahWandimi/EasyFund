package com.muendo.k_changa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.muendo.k_changa.adapters.DonationAdapter;
import com.muendo.k_changa.databinding.ActivityDashBinding;
import com.muendo.k_changa.databinding.ActivityMainBinding;
import com.muendo.k_changa.model.Contributor;
import com.muendo.k_changa.repository.ContributorRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerView recyclerView;
    LinearProgressIndicator progressIndicator;
    TextView txtCurrentAmount, txtTargetAmount, txtPercentage;
    ArrayList<Contributor> contributors;
    DonationAdapter  adapter;
    ContributorRepository contributorRepository;
    ActivityDashBinding dashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.dntRecyclerView;
        progressIndicator = binding.progressBar;
        txtCurrentAmount = binding.txtCurrentAmt;
        txtTargetAmount = binding.txtTargetAmt;
        txtPercentage = binding.txtProgress;

        }

}