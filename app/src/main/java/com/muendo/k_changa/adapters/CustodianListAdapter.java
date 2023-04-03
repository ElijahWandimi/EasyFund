package com.muendo.k_changa.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.muendo.k_changa.R;
import com.muendo.k_changa.model.Custodian;
import com.muendo.k_changa.ui.notifications.DonationEventActivity;

import java.util.ArrayList;

public class CustodianListAdapter extends RecyclerView.Adapter<CustodianListAdapter.ViewHolder>{
    private ArrayList<Custodian> custodians;
    private Context context;

    public CustodianListAdapter(ArrayList<Custodian> custodians, Context context) {
        this.custodians = custodians;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.custodian_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(custodians.get(position).getName());
        holder.role.setText(custodians.get(position).getRole());
        holder.email.setText(custodians.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return custodians.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView name, role, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtCustodianName);
            role = itemView.findViewById(R.id.txtCustodianRole);
            email = itemView.findViewById(R.id.txtCustodianEmail);
        }

        public void bind(Custodian custodian) {
            name.setText(custodian.getName());
            role.setText(custodian.getRole());
            email.setText(custodian.getEmail());
        }
    }
}
