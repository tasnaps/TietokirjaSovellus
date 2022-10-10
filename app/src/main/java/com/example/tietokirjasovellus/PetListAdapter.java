package com.example.tietokirjasovellus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class PetListAdapter extends
        RecyclerView.Adapter<PetListAdapter.ViewHolder> {

    Pet[] localDataset;

    public PetListAdapter(Pet[] dataset){
        localDataset = dataset;
    }

    View.OnClickListener PetListClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            int position = (int) view.getTag();

            Bundle bundle = new Bundle();
            bundle.putString("petName", localDataset[position].name);

            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.itemDetailsFragment, bundle);
        }
    };



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pet_list_item, parent, false);

        return new ViewHolder(view);
    };

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(PetListClickListener);
        holder.textView.setText(localDataset[position].name);
        holder.imageView.setImageResource(localDataset[position].imageId);
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public final ImageView imageView;
        public final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivPetIcon);
            textView = (TextView) itemView.findViewById(R.id.tvPetName);
        }
    }
}
