package com.example.clone_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    ArrayList<Item> itemList;

    public ItemAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
    @NonNull
    @Override

    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_look, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.email.setText(itemList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
