package com.example.dosteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_one);
    }
    public void toList(View view){
        Intent intent = new Intent(UserOneActivity.this, ListOfHobbiesActivity.class);
        startActivity(intent);
}
}
