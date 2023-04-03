package com.muendo.k_changa.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.muendo.k_changa.R;
import com.muendo.k_changa.adapters.DonationAdapter;
import com.muendo.k_changa.databinding.FragmentHomeBinding;
import com.muendo.k_changa.model.Contributor;
import com.muendo.k_changa.model.DonationEvent;
import com.muendo.k_changa.repository.ContributorRepository;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public static DonationEvent donationEvent;
    RecyclerView recyclerView;
    LinearProgressIndicator progressIndicator;
    TextView txtCurrentAmount, txtTargetAmount, txtPercentage;
    ArrayList<Contributor> contributors;
    DonationAdapter adapter;
    ContributorRepository contributorRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initData();
        recyclerView = view.findViewById(R.id.dntRecyclerView);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void initRecyclerView() {
        recyclerView = binding.dntRecyclerView;
        adapter = new DonationAdapter(contributors, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        int currentAmount = 0;
        for (Contributor contributor: contributors) {
            currentAmount += contributor.getContributions();
        }
        binding.txtCurrentAmt.setText(String.valueOf(currentAmount));
        donationEvent = new DonationEvent("Fundraiser", "Fundraiser for the orphans", 5896, 200000L);
        binding.txtTargetAmt.setText(String.valueOf(donationEvent.getTargetAmount()));
//        binding.txtProgress.setText(String.valueOf((currentAmount/Math.toIntExact(donationEvent.getTargetAmount())*100)));
        binding.progressBar.setMax(Math.toIntExact(donationEvent.getTargetAmount()));
        binding.progressBar.setProgress(currentAmount);

    }

    public void initData() {
        System.out.println("initData called");
        contributors = new ArrayList<>();

        /*
         * fetch data from the database
         * creates a list of contributors
         * */
        contributorRepository = new ContributorRepository();
//            contributors = contributorRepository.getContributors();

        contributors.add(new Contributor("John Doe", 1000));
        contributors.add(new Contributor("Omondi Steve", 2000));
        contributors.add(new Contributor("Kipn'geno Vincent", 3000));
        contributors.add(new Contributor("Brian Muendo", 4000));
        contributors.add(new Contributor("Samule Muthembwa", 5000));
        contributors.add(new Contributor("Elijah Wandimi", 6000));
        contributors.add(new Contributor("Lynne Munini", 7000));
        contributors.add(new Contributor("John Ngari", 8000));
        contributors.add(new Contributor("Edmond Kiprui", 9000));
        contributors.add(new Contributor("Ruth Murage", 10000));
        contributors.add(new Contributor("Linux Kamau", 11000));
        contributors.add(new Contributor("Jane Mwangi", 12000));
        contributors.add(new Contributor("Abedi Kal", 13000));
        contributors.add(new Contributor("Geoff Manu", 14000));
        contributors.add(new Contributor("Luis Kinuthia", 15000));
        contributors.add(new Contributor("Lisa Joy", 16000));
        contributors.add(new Contributor("Baki Kimani", 17000));

        initRecyclerView();

    }
}