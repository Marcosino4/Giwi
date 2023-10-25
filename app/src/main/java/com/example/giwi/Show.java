package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        showElements();
    }
    public void changeToLogin(View view){
        Intent nIntent = new Intent(Show.this, Login.class);
        startActivity(nIntent);
    }
    public void changeToUpdate(View view){
        Intent nIntent = new Intent(Show.this, Update.class);
        startActivity(nIntent);
    }
    public void refresh(View view){
        Intent nIntent = new Intent(Show.this, Show.class);
        startActivity(nIntent);
    }

    void showElements(){
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        LinearLayout layout = findViewById(R.id.layoutNombres);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String pass = cursor.getString(2);

                TextView data = new TextView(this);
                data.setText(id+"Nombre: "+name+" Password: "+ pass);
                layout.addView(data);
            }while(cursor.moveToNext());
        }
        db.close();
    }
    public void deleteValues(View v){
        TextView nameTextView = findViewById(R.id.nameShow);
        TextView emailTextView = findViewById(R.id.emailShow);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

        SQLiteDatabase db = new DatabaseAux(Show.this).getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty()) {

            long res = db.delete("users", "name= '"+nameString+"' and email='"+emailString+"'", null);

            if (res > 0){
                Toast.makeText(this, "Borrado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
            }else{
                Toast.makeText(this, "Fallo al borrar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }else{
            Toast.makeText(this, "Error al acceder a la base de datos", Toast.LENGTH_LONG).show();
        }
    }

}