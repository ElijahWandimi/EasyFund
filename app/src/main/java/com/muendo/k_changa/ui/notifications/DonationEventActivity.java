package com.muendo.k_changa.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.muendo.k_changa.adapters.CustodianListAdapter;
import com.muendo.k_changa.databinding.ActivityDonationEventBinding;
import com.muendo.k_changa.model.DonationEvent;

public class DonationEventActivity extends AppCompatActivity {
    ActivityDonationEventBinding binding;
    TextView title, description, targetAmount, payBillNumber;
    ShapeableImageView eventImage;
    ListView custodiansList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDonationEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title = binding.txtDonationEventTitle;
        description = binding.txtDonationEventDescription;
        targetAmount = binding.txtDonationEventTarget;
        payBillNumber = binding.txtDonationEventPayBill;
        eventImage = binding.imgDonationEvent;
        custodiansList = binding.listDonationEventCustodian;

    }

}