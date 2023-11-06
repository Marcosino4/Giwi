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

import com.example.giwi.Database.DatabaseAux;

public class Login extends AppCompatActivity {
    private DatabaseAux aux;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast.makeText(this, "holaa", Toast.LENGTH_SHORT).show();
        aux = new DatabaseAux(Login.this);
        db = aux.getWritableDatabase();

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



            if(db != null && !emailString.isEmpty() && !passString.isEmpty()) {
                String pasarName="loading";
                String pasarEmail="loading";
                String compPass="";

                    Cursor c = db.rawQuery("SELECT name, password FROM users WHERE email ='" +emailString+ "' AND password ='" +passString+ "'", null);
                    if(c.moveToFirst()){
                        pasarName = c.getString(c.getColumnIndex("name"));
                        compPass = c.getString(c.getColumnIndex("password"));
                    }
                    pasarEmail = emailString;

                   if(compPass.equals(passString)){
                       Intent nIntent = new Intent(Login.this, Profile.class);
                       nIntent.putExtra("name", pasarName);
                       nIntent.putExtra("email", pasarEmail);
                       startActivity(nIntent);
                   }else{
                       Toast.makeText(this, "Intentelo de nuevo", Toast.LENGTH_SHORT).show();

                   }

                }

            }

        }







