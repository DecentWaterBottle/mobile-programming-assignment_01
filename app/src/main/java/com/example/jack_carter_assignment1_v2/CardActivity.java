package com.example.jack_carter_assignment1_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {


    //====================================================
    // Activity handles each individual page about a wonder
    //====================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        ImageView image = findViewById(R.id.view_card_image);
        TextView description = (TextView) findViewById(R.id.view_card_desc);
        Button loc_button = (Button) findViewById(R.id.loc_button);
        Bundle intent_extras = getIntent().getExtras();
        Integer choice = (Integer) intent_extras.get("choice");


        //====================================================
        // Open location
        //====================================================
        loc_button.setOnClickListener((View v) -> {
            String location_name = (String) intent_extras.get("names");
            location_name += " wonder";
            Uri addressUri = Uri.parse("geo:0,0?q=" + location_name);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
            startActivity(intent);
        });

        //====================================================
        // Display the appropriate page based on what the user touched
        //====================================================
        switch (choice) {
            case 0:
                description.setText(R.string.great_wall_of_china_desc);
                Glide.with(this).load(R.drawable.great_wall_of_china).into(image);
                break;
            case 1:
                description.setText(R.string.chichen_itza_desc);
                Glide.with(this).load(R.drawable.chicken_itza).into(image);
                break;
            case 2:
                description.setText(R.string.petra_desc);
                Glide.with(this).load(R.drawable.petra).into(image);
                break;
            case 3:
                description.setText(R.string.machu_piccu_desc);
                Glide.with(this).load(R.drawable.machu_picchu).into(image);
                break;
            case 4:
                description.setText(R.string.christ_the_redeemer_desc);
                Glide.with(this).load(R.drawable.christ_the_redeemer).into(image);
                break;
            case 5:
                description.setText(R.string.colosseum_desc);
                Glide.with(this).load(R.drawable.colosseum).into(image);
                break;
            case 6:
                description.setText(R.string.taj_mahal_desc);
                Glide.with(this).load(R.drawable.taj_mahal).into(image);
                break;
        }
    }
}