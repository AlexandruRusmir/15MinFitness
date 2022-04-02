package com.example.proiectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class CurrentWorkingExerciseActivity extends AppCompatActivity {

    Exercise selectedExercise;

    private static final long START_TIME_IN_MILLIS = 5000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private Button skipButton;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    public static int currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_working_exercise);

        getSelectedExercise();
        setValues();

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        skipButton = findViewById(R.id.skipButton);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                if(currentId == WorkoutExercisesListActivity.exercises.size()-1){
                    WorkoutExercisesListActivity.exercises.clear();
                    Intent intent = new Intent(CurrentWorkingExerciseActivity.this, WorkoutEndActivity.class);
                    startActivity(intent);
                }
                else {
                    currentId = currentId + 1;
                    Intent intent = new Intent(CurrentWorkingExerciseActivity.this, BreakActivity.class);
                    startActivity(intent);
                }
            }
        });

        startTimer();
        updateCountDownText();
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

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                if(currentId == WorkoutExercisesListActivity.exercises.size()-1){
                    WorkoutExercisesListActivity.exercises.clear();
                    Intent intent = new Intent(CurrentWorkingExerciseActivity.this, WorkoutEndActivity.class);
                    startActivity(intent);
                }
                else {
                    currentId = currentId + 1;
                    Intent intent = new Intent(CurrentWorkingExerciseActivity.this, BreakActivity.class);
                    startActivity(intent);
                }
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}