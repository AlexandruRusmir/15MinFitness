package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BodyweightDetailActivity extends AppCompatActivity {

    Exercise selectedExercise;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        backButton = findViewById(R.id.back_button4);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BodyweightDetailActivity.this, BodyweightActivity.class);
                startActivity(intent);
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
