package com.example.proiectpdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class BodyStatsActivity extends AppCompatActivity {

    static String BMICalculator(double Height, double Weight){
        double BMIValue = Math.round((Weight/Height/Height*10000.0)*100.0)/100.0;
        String BMIText;
        if(BMIValue < 18.5)
            BMIText = " (underweight)";
        else if(BMIValue >= 18.5 && BMIValue < 25)
            BMIText = " (normal weight)";
        else if(BMIValue >= 25 && BMIValue < 30)
            BMIText = " (overweight)";
        else
            BMIText = " (obese)";
        return String.valueOf(BMIValue) + BMIText;
    }

    static String MinimalProteinCalculator(double Weight){
        double ProteinValue = Math.round((Weight * 1.2) * 100.0)/100.0;
        return String.valueOf(ProteinValue) + " grams";
    }

    static String MinimalWaterCalculator(double Weight){
        double WaterValue = Math.round((Weight*0.04)*100.0)/100.0;
        return String.valueOf(WaterValue) + " liters";
    }

    private Button backButton, getStatsButton;
    private TextView title, BMI, BMI2, Protein, Protein2, Water, Water2;
    private EditText HeightInput, WeightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_stats);

        backButton = findViewById(R.id.back_button);
        title = findViewById(R.id.bodyStats);
        BMI = findViewById(R.id.BMI);
        BMI2 = findViewById(R.id.BMI2);
        Protein = findViewById(R.id.Protein);
        Protein2 = findViewById(R.id.Protein2);
        Water = findViewById(R.id.Water);
        Water2 = findViewById(R.id.Water2);
        title.setVisibility(View.INVISIBLE);
        BMI.setVisibility(View.INVISIBLE);
        BMI2.setVisibility(View.INVISIBLE);
        Protein.setVisibility(View.INVISIBLE);
        Protein2.setVisibility(View.INVISIBLE);
        Water.setVisibility(View.INVISIBLE);
        Water2.setVisibility(View.INVISIBLE);
        getStatsButton = findViewById(R.id.getStats);
        HeightInput = findViewById(R.id.heightInput);
        WeightInput = findViewById(R.id.weightInput);

        AlertDialog alertDialog = new AlertDialog.Builder(BodyStatsActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Please enter a number in both fields!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Got it!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BodyStatsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String H = HeightInput.getText().toString();
                String W = WeightInput.getText().toString();
                try {
                    double Height = Double.valueOf(H);
                    double Weight = Double.valueOf(W);

                    BMI2.setText(BMICalculator(Height, Weight));
                    Protein2.setText(MinimalProteinCalculator(Weight));
                    Water2.setText(MinimalWaterCalculator(Weight));

                    title.setVisibility(View.VISIBLE);
                    BMI.setVisibility(View.VISIBLE);
                    BMI2.setVisibility(View.VISIBLE);
                    Protein.setVisibility(View.VISIBLE);
                    Protein2.setVisibility(View.VISIBLE);
                    Water.setVisibility(View.VISIBLE);
                    Water2.setVisibility(View.VISIBLE);
                }
                catch (Exception e){
                    alertDialog.show();
                };

            }
        });
    }
}