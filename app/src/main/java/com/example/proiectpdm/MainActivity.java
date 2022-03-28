package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button myBtn, myBtn2;
    private TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.textView2);
        Random rand = new Random();
        int upperbound = 4;
        int int_random = rand.nextInt(upperbound);
        if(int_random == 0)
            message.setText("The time to become fitter is now!");
        else if(int_random == 1)
            message.setText("Do the hardk work!");
        else if(int_random == 2)
            message.setText("Get stronger every day!");
        else
            message.setText("Become the best version of yourself!");

        myBtn = findViewById(R.id.bodyStatsButton);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BodyStatsActivity.class);
                startActivity(intent);
            }
        });

        myBtn2 = findViewById(R.id.workoutButton);
        myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WorkoutPage.class);
                startActivity(intent);
            }
        });
    }
}