package com.example.tietokirjasovellus;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class listViewFragment extends Fragment {

    listViewFragment(){super(R.layout.fragment_list_view);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        RecyclerView rvItemList = view.findViewById(R.id.rvPetList);

        Pet[] dataset = MainActivity.database.petDao().getAllPets();
        rvItemList.setAdapter(new PetListAdapter(dataset));
        rvItemList.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}