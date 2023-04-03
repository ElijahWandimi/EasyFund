package com.muendo.k_changa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.muendo.k_changa.R;
import com.muendo.k_changa.model.Contributor;

import java.util.ArrayList;
import java.util.List;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {
    private ArrayList<Contributor> contributors;
    private Context context;

    public DonationAdapter(ArrayList<Contributor> contributors, Context context) {
        this.contributors = contributors;
        this.context = context;
    }

    @NonNull
    @Override
    public DonationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DonationAdapter.ViewHolder holder, int position) {
        int contributions = contributors.get(position).getContributions();
        String name = contributors.get(position).getName();
        holder.bind(new Contributor(name, contributions));
        holder.bind(contributors.get(position));

        holder.name.setText(contributors.get(position).getName());
        holder.contributions.setText(String.valueOf(contributors.get(position).getContributions()));
        holder.avatar.setImageResource(R.drawable.baseline_contacts_24);
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView name, contributions;
        ShapeableImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            contributions = itemView.findViewById(R.id.txtAmt);
            avatar = itemView.findViewById(R.id.img);
        }

        public void bind(Contributor contributor) {
            name.setText(contributor.getName());
            contributions.setText(String.valueOf(contributor.getContributions()));
            avatar.setImageResource(R.drawable.baseline_contacts_24);
        }
    }
}
