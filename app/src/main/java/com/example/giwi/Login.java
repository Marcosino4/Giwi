package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }
    public void changeToSignin(View view){
        Intent nIntent = new Intent(Login.this, SignIn.class);
        startActivity(nIntent);
    }
    @SuppressLint("Range")
    public void logIn(View view){

        TextView emailTextView = findViewById(R.id.emailLogin);
        TextView passTextView = findViewById(R.id.passLogin);

        String emailString = emailTextView.getText().toString();
        String passString = passTextView.getText().toString();

            }

        }







