package com.example.dosteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

