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

public class DumbbellExerciseAdapter extends ArrayAdapter<Exercise> {

    public DumbbellExerciseAdapter(Context context, int resource, List<Exercise> exerciseList) {
        super(context, resource, exerciseList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Exercise exercise = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_cell, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.exerciseName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.exerciseImage);

        tv.setText(exercise.getName());
        iv.setImageResource(exercise.getImage());


        return convertView;
    }
}