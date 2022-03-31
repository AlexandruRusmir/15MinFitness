package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutListDetailActivity extends AppCompatActivity {

    Exercise selectedExercise;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list_detail);

        backButton = findViewById(R.id.back_button4);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutListDetailActivity.this, WorkoutExercisesListActivity.class);
                startActivity(intent);
            }
        });

        getSelectedExercise();
        setValues();

    }

    private void getSelectedExercise() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedExercise = WorkoutExercisesListActivity.exercises.get(Integer.valueOf(parsedStringID));
    }

    private void setValues() {
        TextView tv = (TextView) findViewById(R.id.exerciseName);
        ImageView iv = (ImageView) findViewById(R.id.exerciseImage);

        tv.setText(selectedExercise.getName());
        iv.setImageResource(selectedExercise.getImage());
    }
}