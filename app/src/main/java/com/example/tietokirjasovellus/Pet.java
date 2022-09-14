package com.example.tietokirjasovellus;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pet {

    @PrimaryKey(autoGenerate = true)
    public int petId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "image_id")
    public int imageId;

    @ColumnInfo(name="main_text")
    public String mainText;
}
