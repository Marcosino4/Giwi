package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
    }

    public void changeToLogin(View view){
        Intent nIntent = new Intent(SignIn.this, Login.class);
        startActivity(nIntent);
    }

    public void insertValues(View v){
        TextView nameTextView = findViewById(R.id.nameSingin);
        TextView lastNameTextView = findViewById(R.id.lastNameSingin);
        TextView emailTextView = findViewById(R.id.emailSingin);
        TextView passTextView = findViewById(R.id.passSingin);

        String nameString = nameTextView.getText().toString();
        String lastNameString = lastNameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String passString = passTextView.getText().toString();


        DatabaseAux aux = new DatabaseAux(SignIn.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !lastNameString.isEmpty() && !emailString.isEmpty() && !passString.isEmpty()) {
            ContentValues values = new ContentValues();

            values.put("name", nameString);
            values.put("lastName", lastNameString);
            values.put("email", emailString);
            values.put("password", passString);


            long res = db.insert( "users", null, values);

            if (res >= 0){
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                startActivity(new Intent(SignIn.this, Profile.class));
            }else{
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }
    }
}