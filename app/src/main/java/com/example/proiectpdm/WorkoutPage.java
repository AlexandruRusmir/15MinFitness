package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutPage extends AppCompatActivity {

    private Button backButton;
    private Button stretchButton;
    private Button bodyweightButton;
    private Button dumbbelButton;
    private Button startYourWorkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_page);

        backButton = findViewById(R.id.back_button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        stretchButton = findViewById(R.id.stretchesButton);
        stretchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutPage.this, StretchActivity.class);
                startActivity(intent);
            }
        });

        bodyweightButton = findViewById(R.id.bodyweightButton);
        bodyweightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutPage.this, BodyweightActivity.class);
                startActivity(intent);
            }
        });

        dumbbelButton = findViewById(R.id.dumbbellButton);
        dumbbelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutPage.this, DumbbellActivity.class);
                startActivity(intent);
            }
        });

        startYourWorkoutButton = findViewById(R.id.startWorkoutButton);
        startYourWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutPage.this, WorkoutExercisesListActivity.class);
                startActivity(intent);
            }
        });
    }
}