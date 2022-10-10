package com.example.tietokirjasovellus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static PetDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = Room.databaseBuilder(getApplicationContext(), PetDatabase.class, "uusikanta").allowMainThreadQueries().build();
                //Room.databaseBuilder(getApplicationContext(), PetDatabase.class, "database-name").allowMainThreadQueries().build();

        PetDao petDao = database.petDao();

        Pet[] allPets = petDao.getAllPets();
        if(allPets.length ==0) InitiatePets(petDao);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void InitiatePets(PetDao dao){

        Pet mustikka = new Pet();

        mustikka.name="Mustikka";
        mustikka.mainText="Mustikka on shetlannin paimenkoira. Tässä kuvassa Mustikka on pentuna. Nykyisin hän on vähän eri näköinen";
        mustikka.imageId=getResources().getIdentifier("mustikka", "drawable", getPackageName());

        Pet lillukka = new Pet();
        lillukka.name = "Lillukka";
        lillukka.mainText="Lillukka on Jack Russelin terrieri";
        lillukka.imageId=getResources().getIdentifier("lillukka", "drawable", getPackageName());

        Pet lola = new Pet();
        lola.name = "Lola";
        lola.mainText = "Lola on jo vanha kissa. Hän viihtyy paljon ulkona ja tykkää metsästää hiiriä.";
        lola.imageId=getResources().getIdentifier("lola", "drawable", getPackageName());

        Pet tupu = new Pet();
        tupu.name = "Tupu";
        tupu.mainText = "Tupu on ärsyttävä kissa joka pissaa lattioille";
        tupu.imageId=getResources().getIdentifier("tupu", "drawable", getPackageName());

        dao.insertAll(mustikka, lillukka, lola, tupu);
    }
}