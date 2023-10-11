package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

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
    public void changeToShow(View view){
        Intent nIntent = new Intent(Login.this, Show.class);
        startActivity(nIntent);
    }

    public void insertValues(View v){
        TextView nameTextView = findViewById(R.id.Username);
        TextView passTextView = findViewById(R.id.Password);

        String nameString = nameTextView.getText().toString();
        String passString = passTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(Login.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !passString.isEmpty()) {
            ContentValues values = new ContentValues();

            values.put("name", nameString);
            values.put("password", passString);

            long res = db.insert( "users", null, values);

            if (res >= 0){
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                passTextView.setText("");
            }else{
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }
    }
}