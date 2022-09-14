package com.example.tietokirjasovellus;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsFragment extends Fragment {

    public ItemDetailsFragment() {super(R.layout.fragment_item_details);}


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView ivPetImage = view.findViewById(R.id.ivPetImage);
        TextView tvPetName = view.findViewById(R.id.tvLemmikkiNimi);
        TextView tvPetText = view.findViewById(R.id.tvLemmikkiTeksti);

        String petName = getArguments().getString("petName");

        Pet pet = MainActivity.database.petDao().findByName(petName);
        if(pet != null){
            ivPetImage.setImageResource(pet.imageId);
            tvPetName.setText(pet.name);
            tvPetText.setText(pet.mainText);
        }
    }
}