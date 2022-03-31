package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BodyweightDetailActivity extends AppCompatActivity {

    Exercise selectedExercise;
    private Button backButton;
    private Button addToWorkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyweight_detail);

        backButton = findViewById(R.id.back_button4);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BodyweightDetailActivity.this, BodyweightActivity.class);
                startActivity(intent);
            }
        });

        addToWorkout =  findViewById(R.id.addButton1);
        addToWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(WorkoutExercisesListActivity.exercises.size()<15) {
                    Exercise exercise = selectedExercise;
                    int workoutListLength = WorkoutExercisesListActivity.exercises.size();
                    exercise.setId(String.valueOf(workoutListLength));
                    WorkoutExercisesListActivity.exercises.add(selectedExercise);

                    Intent intent = new Intent(BodyweightDetailActivity.this, BodyweightActivity.class);
                    startActivity(intent);
                }
                else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast));
                    TextView toastText = layout.findViewById(R.id.toastText);
                    toastText.setText("Can not have more than 15 exercises!");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
            }
        });

        getSelectedExercise();
        setValues();

    }

    private void getSelectedExercise() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedExercise = BodyweightActivity.exercises.get(Integer.valueOf(parsedStringID));
    }

    private void setValues() {
        TextView exercisename = (TextView) findViewById(R.id.exerciseName);
        ImageView exerciseimage = (ImageView) findViewById(R.id.exerciseImage);

        exercisename.setText(selectedExercise.getName());
        exerciseimage.setImageResource(selectedExercise.getImage());
    }
}
