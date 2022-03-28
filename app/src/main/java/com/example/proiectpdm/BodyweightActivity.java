package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class BodyweightActivity extends AppCompatActivity {

    public static ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    private ListView listView;
    private Button backButton;
    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyweight);

        backButton = findViewById(R.id.back_button5);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BodyweightActivity.this, WorkoutPage.class);
                startActivity(intent);
            }
        });

        initSearchWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void initSearchWidgets() {
        searchView = (SearchView) findViewById(R.id.exerciseListView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText = s;
                ArrayList<Exercise> filteredExercises = new ArrayList<Exercise>();

                for(Exercise exercise: exercises) {
                    if(exercise.getName().toLowerCase().contains(s.toLowerCase())) {
                        if(selectedFilter.equals("all")) {
                            filteredExercises.add(exercise);
                        }
                        else {
                            if(exercise.getName().toLowerCase().contains(selectedFilter)) {
                                filteredExercises.add(exercise);
                            }
                        }
                    }
                }
                BodyweightExerciseAdapter adapter = new BodyweightExerciseAdapter(getApplicationContext(), 0, filteredExercises);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }

    private void setupData() {
        exercises.clear();
        Exercise widePushup = new Exercise("0", "Wide grip push up\n(push)", R.drawable.wide_grip_push_up);
        exercises.add(widePushup);

        Exercise pullUp = new Exercise("1", "Pull up\n(pull)", R.drawable.pull_up);
        exercises.add(pullUp);

        Exercise splitSquat = new Exercise("2", "Bulgarian split squats\n(legs)", R.drawable.bulgarian_split_squats);
        exercises.add(splitSquat);

        Exercise plank = new Exercise("3", "Plank\n(core)", R.drawable.plank);
        exercises.add(plank);

        Exercise pikePushup = new Exercise("4", "Pike push up\n(push)", R.drawable.pike_push_up);
        exercises.add(pikePushup);

        Exercise burpeeTuckJump = new Exercise("5", "Burpee tuck jump\n(full body)", R.drawable.burpee_tuck_jump);
        exercises.add(burpeeTuckJump);

        Exercise deepSquat = new Exercise("6", "Deep squat\n(legs)", R.drawable.deep_squat);
        exercises.add(deepSquat);

        Exercise chinUp = new Exercise("7", "Chin up\n(pull)", R.drawable.chin_up);
        exercises.add(chinUp);

        Exercise jumpingLunge = new Exercise("8", "Jumping Lunge\n(legs)", R.drawable.jumping_lunge);
        exercises.add(jumpingLunge);

        Exercise spiderPushup = new Exercise("9", "Spiderman push up\n(push)", R.drawable.spider_man_push_up);
        exercises.add(spiderPushup);

        Exercise deadHang = new Exercise("10", "Dead hang\n(pull)", R.drawable.dead_hang);
        exercises.add(deadHang);

        Exercise bridgeKick = new Exercise("11", "Bridge kick\n(legs)", R.drawable.bridge_kick);
        exercises.add(bridgeKick);

        Exercise inclineClapPushup = new Exercise("12", "Incline clap Push up\n(push)", R.drawable.incline_clap_push_up);
        exercises.add(inclineClapPushup);

        Exercise squatJump = new Exercise("13", "Jumping Squat\n(legs)", R.drawable.squat_jump_with_floor_touch);
        exercises.add(squatJump);

        Exercise burpeeToChinup = new Exercise("14", "Burpee to Chin up\n(full body)", R.drawable.burpee_to_chin_up);
        exercises.add(burpeeToChinup);

        Exercise pushupToBurpee = new Exercise("15", "Push up to burpee\n(full body)", R.drawable.push_up_to_burpee);
        exercises.add(pushupToBurpee);

        Exercise hangingLegRaise = new Exercise("16", "Hanging Leg raise\n(core)", R.drawable.hanging_leg_raise);
        exercises.add(hangingLegRaise);

        Exercise shrimpSquat = new Exercise("17", "Shrimp Squat\n(legs)", R.drawable.shrimp_squat);
        exercises.add(shrimpSquat);
    }

    private void setUpList() {
        listView = (ListView) findViewById(R.id.exercisesListView);

        BodyweightExerciseAdapter adapter = new BodyweightExerciseAdapter(getApplicationContext(), 0, exercises);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Exercise selectExercise = (Exercise) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), BodyweightDetailActivity.class);
                showDetail.putExtra("id", selectExercise.getId());
                startActivity(showDetail);
            }
        });

    }



    private void filterList(String status) {
        selectedFilter = status;
        ArrayList<Exercise> filteredExercises = new ArrayList<Exercise>();
        for(Exercise exercise: exercises) {
            if(exercise.getName().toLowerCase().contains(status)) {
                if(currentSearchText == "") {
                    filteredExercises.add(exercise);
                }
                else {
                    if(exercise.getName().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        filteredExercises.add(exercise);
                    }
                }
            }
        }

        BodyweightExerciseAdapter adapter = new BodyweightExerciseAdapter(getApplicationContext(), 0, filteredExercises);
        listView.setAdapter(adapter);
    }




    public void allFilterTapped(View view)
    {
        selectedFilter = "all";

        BodyweightExerciseAdapter adapter = new BodyweightExerciseAdapter(getApplicationContext(), 0, exercises);
        listView.setAdapter(adapter);
    }

    public void fullBodyFilterTapped(View view)
    {
        filterList("full body");
    }

    public void pushFilterTapped(View view)
    {
        filterList("push");
    }

    public void pullFilterTapped(View view)
    {
        filterList("pull");
    }

    public void legsFilterTapped(View view)
    {
        filterList("legs");
    }

    public void coreFilterTapped(View view)
    {
        filterList("core");
    }
}