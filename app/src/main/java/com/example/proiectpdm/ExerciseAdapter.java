package com.example.proiectpdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
    public ExerciseAdapter(Context context, int resource, List<Exercise> exerciseList) {
        super(context, resource, exerciseList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Exercise exercise = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_cell, parent, false);
        }
        TextView textview = (TextView) convertView.findViewById(R.id.exerciseName);
        ImageView imgview = (ImageView) convertView.findViewById(R.id.exerciseImage);

        textview.setText(exercise.getName());
        imgview.setImageResource(exercise.getImage());

        return convertView;
    }
}