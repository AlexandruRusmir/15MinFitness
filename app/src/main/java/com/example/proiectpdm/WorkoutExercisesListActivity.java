package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkoutExercisesListActivity extends AppCompatActivity {

    public static ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    private Button backButton;
    private Button emptyListButtton;
    private Button startWorkout;
    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_exercises_list);

        startWorkout = findViewById(R.id.startWorkoutButton2);
        if(!exercises.isEmpty())
            startWorkout.setVisibility(View.VISIBLE);

        backButton = findViewById(R.id.back_button3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutExercisesListActivity.this, WorkoutPage.class);
                startActivity(intent);
            }
        });

        emptyListButtton = findViewById(R.id.emptyListButton);
        emptyListButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercises.clear();
                Intent intent = new Intent(WorkoutExercisesListActivity.this, WorkoutExercisesListActivity.class);
                startActivity(intent);
            }
        });

        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exercise exercise = (Exercise) (listView.getItemAtPosition(0));
                Intent showDetail = new Intent(getApplicationContext(), CurrentWorkingExerciseActivity.class);
                showDetail.putExtra("id",exercise.getId());
                startActivity(showDetail);
            }
        });

        setUpList();
        setUpOnclickListener();
    }


    private void setUpList() {
        listView = (ListView) findViewById(R.id.selectedExercisesListView);
        ExerciseAdapter adapter = new ExerciseAdapter(getApplicationContext(), 0, exercises);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Exercise exercise = (Exercise) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), WorkoutListDetailActivity.class);
                showDetail.putExtra("id",exercise.getId());
                startActivity(showDetail);
            }
        });
    }
}