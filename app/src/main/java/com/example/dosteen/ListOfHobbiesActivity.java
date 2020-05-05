package com.example.dosteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AppOpsManager;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

public class ListOfHobbiesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHobby;
    private RecyclerView.Adapter recycleViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_hobbies);

        Window w = getWindow();
        w.setTitle("Спорт");

        ArrayList<ItemOfListOfHobbies> hobbyArray= new ArrayList<>();
        hobbyArray.add(new ItemOfListOfHobbies("Баскетбол", "ул.Ленинрадский пр-скет, Олимп"));
        recyclerViewHobby = findViewById(R.id.recyclerView);
        recyclerViewHobby.setHasFixedSize(true);
        recycleViewAdapter = new RecyclerViewAdapter(hobbyArray);
        layoutManager = new LinearLayoutManager(this);


        recyclerViewHobby.setAdapter(recycleViewAdapter);
        recyclerViewHobby.setLayoutManager(layoutManager);
    }
}
