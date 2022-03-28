package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StretchActivity extends AppCompatActivity {

    public static ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    private Button backButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch);
        backButton = findViewById(R.id.back_button3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StretchActivity.this, WorkoutPage.class);
                startActivity(intent);
            }
        });
        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData() {
        exercises.clear();

        Exercise butterfly = new Exercise("0", "Butterfly stretch", R.drawable.butterfly_stretch);
        exercises.add(butterfly);

        Exercise chestAndShoulder = new Exercise("1","Chest/shoulder stretch", R.drawable.chest_and_shoulder_stretch);
        exercises.add(chestAndShoulder);

        Exercise cobra = new Exercise("2","Cobra stretch", R.drawable.cobra);
        exercises.add(cobra);

        Exercise hamstring = new Exercise("3","Hamstring stretch", R.drawable.standing_hamstring_stretch);
        exercises.add(hamstring);

        Exercise glute = new Exercise("4","Glute bridge", R.drawable.glute_bridge);
        exercises.add(glute);

        Exercise neck = new Exercise("5","Sideways neck stretch", R.drawable.sideways_neck_stretch);
        exercises.add(neck);

        Exercise lunge = new Exercise("6", "Lunge stretch", R.drawable.lunge_stretch);
        exercises.add(lunge);

        Exercise kneeToChest = new Exercise("7","Knee to chest stretch", R.drawable.lying_knee_to_chest);
        exercises.add(kneeToChest);

        Exercise calf = new Exercise("8","Calf stretch", R.drawable.calf_stretch);
        exercises.add(calf);

        Exercise hipFlexor = new Exercise("9","Hip flexor stretch", R.drawable.standing_hip_flexor_stretch);
        exercises.add(hipFlexor);

        Exercise quad = new Exercise("10","Standing quad stretch", R.drawable.standing_quad_stretch);
        exercises.add(quad);
    }

    private void setUpList() {
        listView = (ListView) findViewById(R.id.stretchesListView);

        ExerciseAdapter adapter = new ExerciseAdapter(getApplicationContext(), 0, exercises);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Exercise exercise = (Exercise) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",exercise.getId());
                startActivity(showDetail);
            }
        });

    }

}