package com.example.dosteen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHobby;
    private RecyclerView.Adapter recycleViewAdapter;
    private RecyclerView.LayoutManager layoutManager;


    private ArrayList<Section> mySections;
    ArrayList<ItemOfListOfHobbies> hobbyArray;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
    String TAG = "testingFirestore";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        Window w = getWindow();
        w.setTitle("Ваши секции");


    }

    @Override
    protected void onStart() {
        super.onStart();
        readData(new FirestoreCallback() {
            @Override
            public void setRecycle(ArrayList<ItemOfListOfHobbies> list) {
                hobbyArray = list;
                recyclerViewHobby = findViewById(R.id.sectionsListForTeacher);
                recyclerViewHobby.setHasFixedSize(true);
                recycleViewAdapter = new RecyclerViewAdapter(hobbyArray);
                layoutManager = new LinearLayoutManager(TeacherActivity.this);


                recyclerViewHobby.setAdapter(recycleViewAdapter);
                recyclerViewHobby.setLayoutManager(layoutManager);


            }
        });
    }

    public void toCreateHobbyActivity(View view){
        startActivity(new Intent(TeacherActivity.this, CreateHobbyActivity.class));
        finish();
    }


    public void readData(final FirestoreCallback firestoreCallback){

        documentReference.collection("sections").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<ItemOfListOfHobbies> list= new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                list.add(new ItemOfListOfHobbies(document.getString("name"), document.getString("location"),
                                        null, null, null));
                            }
                            firestoreCallback.setRecycle(list);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
    private interface FirestoreCallback{
        void setRecycle(ArrayList<ItemOfListOfHobbies> list);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            startActivity(new Intent(TeacherActivity.this, MainActivity.class));
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
