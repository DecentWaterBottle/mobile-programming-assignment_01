package com.example.jack_carter_assignment1_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //====================================================
    // The initial activity the app loads
    //====================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button = (Button) findViewById(R.id.button);

        // Button Pulse
        ValueAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(start_button,
                PropertyValuesHolder.ofFloat("scaleX", 1.8f),
                PropertyValuesHolder.ofFloat("scaleY", 1.8f)

        );
        // Activating button pulse
        scaleDown.setDuration(500);
        scaleDown.setRepeatMode(ValueAnimator.REVERSE);
        scaleDown.setRepeatCount(ValueAnimator.INFINITE);
        scaleDown.start();

        // Button to go to list of wonders
        start_button.setOnClickListener((View v) -> {
            Intent send_to_main = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(send_to_main);
        });
    }
}