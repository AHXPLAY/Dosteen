package com.example.dosteen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.service.autofill.Validators.and;

public class RegistrationActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    EditText email;
    EditText password;
    EditText repeatPassword;
    TextView repeatHedaer;
    Button SignInOrUp;
    TextView changToLoginOrSignIn;
    private static final String TAG = "RegistrationActivity";
    private boolean loginModeActive = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editemail);
        password = findViewById(R.id.editpass);
        SignInOrUp = findViewById(R.id.regButton);
        changToLoginOrSignIn = findViewById(R.id.changing);
        repeatPassword = findViewById(R.id.editrepeatpass);
        repeatHedaer = findViewById(R.id.repeatpass);
    }

    public void toSignIn(View view) {
        if ((email.getText().toString().trim().length() == 0) || (password.getText().toString().trim().length() == 0)) {
            Toast.makeText(RegistrationActivity.this, "Вы не заполнили одно из полей", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().trim().length() < 6) {
            Toast.makeText(RegistrationActivity.this, "Пароль должен быть длиннее 6 символов", Toast.LENGTH_SHORT).show();
        }
        else if (!(password.getText().toString().trim().equals(repeatPassword.getText().toString().trim())) && (repeatPassword.getVisibility() == View.VISIBLE)) {
            Toast.makeText(RegistrationActivity.this, "Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
        }

        else {

            loginOrSignUpUser(email.getText().toString().trim(), password.getText().toString().trim());
        }


    }
   public void loginOrSignUpUser(String email, final String password) {
       if (loginModeActive) {
           auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()) {
                       // Sign in success, update UI with the signed-in user's information
                       Log.d(TAG, "createUserWithEmail:success");
                       FirebaseUser user = auth.getCurrentUser();
                       startActivity(new Intent(RegistrationActivity.this, MainActivity.class));

                       // updateUI(user);

                   } else {
                       // If sign in fails, display a message to the user.
                       Log.w(TAG, "createUserWithEmail:failure", task.getException());
                       Toast.makeText(RegistrationActivity.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                       //updateUI(null);
                   }
               }
           });
       }else {

           auth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               // Sign in success, update UI with the signed-in user's information
                               Log.d(TAG, "signInWithEmail:success");
                               FirebaseUser user = auth.getCurrentUser();
                               startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                              // updateUI(user);
                           } else {
                               // If sign in fails, display a message to the user.
                               Log.w(TAG, "signInWithEmail:failure", task.getException());
                               Toast.makeText(RegistrationActivity.this, "Ошибка входа",
                                       Toast.LENGTH_SHORT).show();
                               //updateUI(null);
                               // ...
                           }

                           // ...
                       }
                   });
       }
   }

    public void toggleLoginMode(View view) {
        if(loginModeActive) {
            loginModeActive = false;
            SignInOrUp.setText("Войти");
            changToLoginOrSignIn.setText("Создать аккаунт");
            repeatPassword.setVisibility(View.GONE);
            repeatHedaer.setVisibility(View.GONE);

        }
        else{
            loginModeActive = true;
            SignInOrUp.setText("Зарегистрироваться");
            changToLoginOrSignIn.setText("Уже есть аккаунт");
            repeatPassword.setVisibility(View.VISIBLE);
            repeatHedaer.setVisibility(View.VISIBLE);

        }

        }
    }



