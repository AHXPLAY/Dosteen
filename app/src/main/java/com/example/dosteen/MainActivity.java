package com.example.dosteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

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

