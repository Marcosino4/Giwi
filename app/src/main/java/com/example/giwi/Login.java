package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast.makeText(this, "holaa", Toast.LENGTH_SHORT).show();
    }
    public void changeToSignin(View view){
        Intent nIntent = new Intent(Login.this, SignIn.class);
        startActivity(nIntent);
    }
    public void logIn(View view){
        TextView emailTextView = findViewById(R.id.emailSingin);
        TextView passTextView = findViewById(R.id.passSingin);

        String emailString = emailTextView.getText().toString();
        String passString = passTextView.getText().toString();


        DatabaseAux aux = new DatabaseAux(Login.this);
        SQLiteDatabase db = aux.getWritableDatabase();

            if(db != null && !emailString.isEmpty() && !passString.isEmpty()) {
                Intent nIntent = new Intent(Login.this, Profile.class);
                startActivity(nIntent);
            }
        }
}


