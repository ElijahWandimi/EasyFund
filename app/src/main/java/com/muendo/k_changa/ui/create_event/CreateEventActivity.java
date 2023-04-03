package com.muendo.k_changa.ui.create_event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.muendo.k_changa.authorise.RegisterActivity;
import com.muendo.k_changa.databinding.ActivityCreateEventBinding;
import com.muendo.k_changa.model.DonationEvent;
import com.muendo.k_changa.ui.notifications.DonationEventActivity;

public class CreateEventActivity extends AppCompatActivity {
    ActivityCreateEventBinding binding;
    ListView custodiansList;
    TextInputEditText title, description, payBillNumber, targetAmount, custodians;
    Button createEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title = binding.eventName;
        description = binding.eventDescription;
        payBillNumber = binding.eventPayBill;
        targetAmount = binding.eventTarget;
        custodians = binding.eventCustodian;
        createEvent = binding.createEvent;
        custodiansList = binding.eventList;

        createEvent.setOnClickListener(v -> {
            String t_name = String.valueOf(title.getText());
            String t_description = String.valueOf(description.getText());
            int t_payBillNumber = Integer.parseInt(String.valueOf(payBillNumber.getText()));
            Long t_targetAmount = Long.parseLong(String.valueOf(targetAmount.getText()));
            String t_custodians = String.valueOf(custodians.getText());
            if (RegisterActivity.isEmpty(t_name) || RegisterActivity.isEmpty(t_description) || RegisterActivity.isEmpty(String.valueOf(t_payBillNumber))
                    || RegisterActivity.isEmpty(String.valueOf(t_targetAmount)) || RegisterActivity.isEmpty(t_custodians)) {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            }
            DonationEvent event = new DonationEvent(t_name, t_description, t_payBillNumber, t_targetAmount);
            Intent intent = new Intent(this, DonationEventActivity.class);
            intent.putExtra("title", t_name);
            intent.putExtra("description", t_description);
            intent.putExtra("payBillNumber", t_payBillNumber);
            intent.putExtra("targetAmount", t_targetAmount);
            intent.putExtra("custodians", t_custodians);
            startActivity(intent);
        });
    }

}