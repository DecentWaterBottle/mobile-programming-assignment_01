package com.example.jack_carter_assignment1_v2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MyRecycleAdapter.ClickListener {


    //====================================================
    // Activity for the menu displaying the cards
    //====================================================

    public ArrayList<String> names;
    MyRecycleAdapter adapter;
    Button bonus_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        final int[] bonus_state = {0};

        bonus_button = (Button) findViewById(R.id.eighth_wonder_button);
        // Names of the wonders
        names = new ArrayList<>();
        names.add("Great Wall of China");
        names.add("Chichén Itzá");
        names.add("Petra");
        names.add("Machu Picchu");
        names.add("Christ the Redeemer");
        names.add("Colosseum");
        names.add("Taj Mahal");

        ArrayList<Integer> images = new ArrayList<>();
        // Images for the wonders
        images.add(R.drawable.great_wall_of_china);
        images.add(R.drawable.chicken_itza);
        images.add(R.drawable.petra);
        images.add(R.drawable.machu_picchu);
        images.add(R.drawable.christ_the_redeemer);
        images.add(R.drawable.colosseum);
        images.add(R.drawable.taj_mahal);

        // Creating recycler view
        RecyclerView recycler = findViewById(R.id.wonders_card_list);
        RecyclerView.LayoutManager layout_manager = new GridLayoutManager(this, 1);
        recycler.setLayoutManager(layout_manager);


        adapter = new MyRecycleAdapter(images, names);
        adapter.setClickListener(this);
        recycler.setAdapter(adapter);

        // Button to display the bonus wonder (Moai on Easter Island)
        // The button displays / hides a fragment which displays the information
        bonus_button.setOnClickListener((View v) -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            eighth_wonder wonder = new eighth_wonder();
            transaction.replace(R.id.frame, wonder);

            if (bonus_state[0] == 0) {
                transaction.commit();
                bonus_state[0] = 1;
            }
            else {
                transaction.remove(wonder).commit();
                bonus_state[0] = 0;
            }
        });
    }

    // The click listener for clicking on a wonder card
    @Override
    public void onItemClick(View view, int choice) {
        Intent intent  = new Intent(MenuActivity.this, CardActivity.class);
        intent.putExtra("choice", choice);
        intent.putExtra("names", names.get(choice));
        startActivity(intent);
    }
}