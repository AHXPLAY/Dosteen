package com.example.dosteen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateHobbyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText name;
    EditText sectionName;
    EditText location;
    EditText contacts;
    Spinner classChoice;
    ArrayList<String> spinnerList;
    ArrayAdapter spinnerAdapter;
    String chosenClass = "Спорт";
    String TAG = "testingFirestore";
    int numOfSections = 2;
    DocumentReference documentReference = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hobby);
        classChoice = findViewById(R.id.classChoice);
        classChoice.setOnItemSelectedListener(this);
        spinnerList = new ArrayList<>();

        spinnerList.add("Спорт");
        spinnerList.add("Образование");
        spinnerList.add("Творчество");
        spinnerList.add("Другое");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classChoice.setAdapter(spinnerAdapter);

        // sectionDBReference = database.getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        name = findViewById(R.id.yourName);
        sectionName = findViewById(R.id.SecName);
        location = findViewById(R.id.location);
        contacts = findViewById(R.id.contacts);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenClass = classChoice.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void toCreateSection(View view) {

        readData(new FirestoreCallback() {
            @Override
            public void setInt(int i) {
                Section newSection = new Section(sectionName.getText().toString(), classChoice.getSelectedItem().toString(), location.getText().toString() );
                numOfSections = i;
                documentReference.update("numOfSections", i + 1);
                Log.d(TAG + " count", "" + i);
                documentReference.update("userName", name.getText().toString());
                documentReference.update("contacts", contacts.getText().toString());
                documentReference.collection("sections").document("section " + numOfSections).set(newSection);
            }
        });
        startActivity(new Intent(CreateHobbyActivity.this, TeacherActivity.class));
        finish();
    }


    public void readData(final FirestoreCallback firestoreCallback) {
        Section newSection = new Section(sectionName.getText().toString(), chosenClass, location.getText().toString());

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                numOfSections = Integer.parseInt(documentSnapshot.get("numOfSections").toString());
                Log.d(TAG, "ggwp");
                firestoreCallback.setInt(numOfSections);
            }
        });


    }

    private interface FirestoreCallback {
        void setInt(int i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(CreateHobbyActivity.this, TeacherActivity.class));
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}