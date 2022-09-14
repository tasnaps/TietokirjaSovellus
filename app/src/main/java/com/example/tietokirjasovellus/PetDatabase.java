package com.example.tietokirjasovellus;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pet.class}, version = 1)
public abstract class PetDatabase extends RoomDatabase {
    public abstract PetDao petDao();
}
