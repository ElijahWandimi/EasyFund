package com.muendo.k_changa.ui.dashboard;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.muendo.k_changa.R;
import com.muendo.k_changa.adapters.CustodianListAdapter;
import com.muendo.k_changa.databinding.FragmentDashboardBinding;
import com.muendo.k_changa.model.Custodian;
import com.muendo.k_changa.model.DonationEvent;
import com.muendo.k_changa.ui.create_event.CreateEventActivity;
import com.muendo.k_changa.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Objects;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    DonationEvent donationEvent = HomeFragment.donationEvent;
    DonationEvent donationEventNew;

    MaterialTextView title, description, targetAmount, payBillNumber;
    ShapeableImageView eventImage;
    RecyclerView custodiansList;
    FloatingActionButton fabAddBtn;
    ArrayList<Custodian> custodians;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        Intent intent = requireActivity().getIntent();
//        String t_name = intent.getStringExtra("title");
//        String t_description = intent.getStringExtra("description");
//        Long t_target = Long.valueOf(intent.getStringExtra("targetAmount"));
//        int t_paybill = Integer.parseInt(intent.getStringExtra("payBillNumber"));
//        String t_custodians = intent.getStringExtra("custodians");
//        donationEventNew = new DonationEvent(t_name, t_description, t_paybill, t_target);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        title = binding.txtDonationEventTitle;
        description = binding.txtDonationEventDescription;
        targetAmount = binding.txtDonationEventTarget;
        payBillNumber = binding.txtDonationEventPayBill;
        eventImage = binding.imgDonationEvent;

        initDataSet();
        custodiansList = view.findViewById(R.id.listDonationEventCustodian);

        fabAddBtn = binding.fabDonationEvent;
        fabAddBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CreateEventActivity.class);
            startActivity(intent);
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void initRecyclerView() {
        custodiansList = binding.listDonationEventCustodian;

        CustodianListAdapter adapter = new CustodianListAdapter(custodians, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        custodiansList.setLayoutManager(layoutManager);
        custodiansList.setHasFixedSize(true);
        custodiansList.setAdapter(adapter);

        updateUI(donationEvent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void updateUI(DonationEvent event) {
        binding.txtDonationEventTitle.setText(event.getTitle());
        description.setText(event.getDescription());
        targetAmount.setText(String.format("%s KSh", event.getTargetAmount()));
        payBillNumber.setText(String.format("%s", event.getPayBillNumber()));
        eventImage.setImageResource(R.drawable.istockphoto_1256079963_612x612);
    }

    public void initDataSet() {
        custodians = new ArrayList<>();
        custodians.add(new Custodian("John Doe", "Admin", "admin@amin.com"));
        custodians.add(new Custodian("Jane Smoke", "User", "jane@smoke.com"));
        custodians.add(new Custodian("Steve Dawson", "User", "dawson@steve.com"));

        initRecyclerView();
    }
}