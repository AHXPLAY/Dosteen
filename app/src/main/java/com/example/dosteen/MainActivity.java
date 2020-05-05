package com.example.dosteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import Data.HobbiesDatabse;
import Model.HobbyGroupElements;

public class MainActivity extends AppCompatActivity {


    private HobbiesDatabse hobbiesDatabse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hobbiesDatabse = Room.databaseBuilder(
                getApplicationContext(), HobbiesDatabse.class, "HobbiesDB").
                allowMainThreadQueries().build();
    }
    public void toKidActivity(View view){
        Intent kidActivity = new Intent(MainActivity.this, UserOneActivity.class);
        startActivity(kidActivity);
    }
    public void toTeacherActivity(View view){
        Intent teacherActivity = new Intent(MainActivity.this, TeacherActivity.class);
        startActivity(teacherActivity);
    }
}

