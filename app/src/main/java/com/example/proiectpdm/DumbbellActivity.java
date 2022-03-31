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

public class DumbbellActivity extends AppCompatActivity {

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
                Intent intent = new Intent(DumbbellActivity.this, WorkoutPage.class);
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
        Exercise benchPress = new Exercise("0", "Bench press\n(push)", R.drawable.bench_press);
        exercises.add(benchPress);

        Exercise bentOverRow = new Exercise("1", "Bent-over row\n(pull)", R.drawable.bent_over_row);
        exercises.add(bentOverRow);

        Exercise bulgSplitSquat = new Exercise("2", "Bulgarian Split squat\n(legs)", R.drawable.bulgarian_split_squat);
        exercises.add(bulgSplitSquat);

        Exercise stepUp = new Exercise("3", "Step up\n(legs)", R.drawable.stepup);
        exercises.add(stepUp);

        Exercise farmersWalk = new Exercise("4", "Farmer's walk\n(core)", R.drawable.farmers_walk);
        exercises.add(farmersWalk);

        Exercise lateralRaise = new Exercise("5", "Lateral raise\n(push)", R.drawable.lateral_raise);
        exercises.add(lateralRaise);

        Exercise tricepsKickBack = new Exercise("6", "Triceps kick-back\n(push)", R.drawable.triceps_kick_back);
        exercises.add(tricepsKickBack);

        Exercise lunge = new Exercise("7", "Lunge\n(legs)", R.drawable.lunge);
        exercises.add(lunge);

        Exercise renegadeRow = new Exercise("8", "Renegade row\n(pull)", R.drawable.renegade_row);
        exercises.add(renegadeRow);

        Exercise singleLegRoDeadlift = new Exercise("9", "Single leg romanian deadlift\n(legs)", R.drawable.single_leg_romanian_deadlift);
        exercises.add(singleLegRoDeadlift);

        Exercise shoulderPress = new Exercise("10", "Shoulder press\n(push)", R.drawable.shoulder_press);
        exercises.add(shoulderPress);

        Exercise calfRaise = new Exercise("11", "Calf raise\n(legs)", R.drawable.calf_raise);
        exercises.add(calfRaise);

        Exercise turkishGetup = new Exercise("12", "Turkish get-up\n(full body)", R.drawable.turkish_getup);
        exercises.add(turkishGetup);

        Exercise floorPress = new Exercise("13", "Floor press\n(push)", R.drawable.floor_press);
        exercises.add(floorPress);

        Exercise squatToPress = new Exercise("14", "Squat to press-up\n(full body)", R.drawable.squat_to_press);
        exercises.add(squatToPress);

        Exercise frontSquat = new Exercise("15", "Front squat\n(legs)", R.drawable.front_squat);
        exercises.add(frontSquat);

        Exercise pullOver = new Exercise("16", "Pull-over\n(pull)", R.drawable.pull_over);
        exercises.add(pullOver);

        Exercise lateralLunge = new Exercise("17", "Lateral lunge\n(legs)", R.drawable.lateral_lunge);
        exercises.add(lateralLunge);

        Exercise dumbbellSnatch = new Exercise("18", "Dumbbell snatch\n(full body)", R.drawable.dumbbell_snatch);
        exercises.add(dumbbellSnatch);

        Exercise bicepsCurl = new Exercise("19", "Biceps curl\n(pull)", R.drawable.biceps_curl);
        exercises.add(bicepsCurl);

        Exercise tPressUp = new Exercise("20", "T-Press\n(core)", R.drawable.t_press_up);
        exercises.add(tPressUp);
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
                Intent showDetail = new Intent(getApplicationContext(), DumbbellDetailActivity.class);
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

        DumbbellExerciseAdapter adapter = new DumbbellExerciseAdapter(getApplicationContext(), 0, filteredExercises);
        listView.setAdapter(adapter);
    }




    public void allFilterTapped(View view)
    {
        selectedFilter = "all";

        DumbbellExerciseAdapter adapter = new DumbbellExerciseAdapter(getApplicationContext(), 0, exercises);
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