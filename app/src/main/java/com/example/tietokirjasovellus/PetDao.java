package com.example.tietokirjasovellus;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pet WHERE petName LIKE :name LIMIT 1")
    Pet findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Pet... pets);

    @Query("SELECT * FROM pet")
    Pet[] getAllPets();

    @Query("DELETE FROM pet")
    void deleteAll();

}

