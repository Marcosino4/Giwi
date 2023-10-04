package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast.makeText(this, "holaa", Toast.LENGTH_SHORT).show();
        Button logIn = findViewById(R.id.LogIn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "ponele el usuario pelotudo", Toast.LENGTH_SHORT).show();
            }
            public void diceAdios(View v){
                Toast.makeText(v.getContext(),"adioos", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void changeToSignin(View view){
        Intent nIntent = new Intent(Login.this, SignIn.class);
        startActivity(nIntent);
    }
}