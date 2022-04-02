package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutEndActivity extends AppCompatActivity {

    private Button stretchButton;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_end);

        stretchButton = findViewById(R.id.stretchesButton);
        stretchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutEndActivity.this, StretchActivity.class);
                startActivity(intent);
            }
        });

        continueButton = findViewById(R.id.goBackToMain);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutEndActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}