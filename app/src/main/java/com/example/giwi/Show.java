package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.giwi.Database.DatabaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
    public void changeToLogin(View view){
        Intent nIntent = new Intent(Show.this, Login.class);
        startActivity(nIntent);
    }

    void showElements(){
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        TextView nameTextView = findViewById(R.id.Username);
        TextView passTextView = findViewById(R.id.Password);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String pass = cursor.getString(2);

                nameTextView.setText(id + " " + name);
                passTextView.setText(pass);
            }while(cursor.moveToNext());
        }
        db.close();
    }
}