package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    private TextView tvName, tvEmail;
    private String name, email;

    private FirebaseAuth authProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        tvName = findViewById(R.id.nameView);
        tvEmail = findViewById(R.id.emailView);

       Intent intent = getIntent();

       String nameR = intent.getStringExtra("name");
       String emailR = intent.getStringExtra("email");

        tvName.setText(nameR);
        tvEmail.setText(emailR);

        email = emailR;



    }

    public void changeToUpdate(View view){
        Intent nIntent = new Intent(Profile.this, UpdateProfile.class);
        nIntent.putExtra("email", email);
        startActivity(nIntent);
        finish();
    }

    public void changeToLogin(View view){
        Intent nIntent = new Intent(Profile.this, Login.class);
        startActivity(nIntent);
        finish();
    }
}