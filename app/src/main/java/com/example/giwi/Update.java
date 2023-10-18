package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        showElements();
    }
    public void refresh(View view){
        Intent nIntent = new Intent(Update.this, Update.class);
        startActivity(nIntent);
    }
    public void changeToLogin(View view){
        Intent nIntent = new Intent(Update.this, Login.class);
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
                data.setText("Nombre: "+name+" Password: "+ pass);
                layout.addView(data);
            }while(cursor.moveToNext());
        }
        db.close();
    }
    public void updateValues(View v){
        TextView nameTextView = findViewById(R.id.nameUpdate);
        TextView emailTextView = findViewById(R.id.emailUpdate);
        TextView newNameTextView = findViewById(R.id.nameUpdateNew);
        TextView newEmailTextView = findViewById(R.id.emailUpdateNew);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String newNameString = newNameTextView.getText().toString();
        String newEmailString = newEmailTextView.getText().toString();

        SQLiteDatabase db = new DatabaseAux(Update.this).getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty()) {
            ContentValues values = new ContentValues();

            values.put("name", newNameString);
            values.put("email", newEmailString);

            long res = db.update("users", values,"name = '"+nameString+"' and email= '"+emailString+"'", null);

            if (res >= 0){
                Toast.makeText(this, "Actualizado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
            }else{
                Toast.makeText(this, "Fallo al actualizar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }else{
            Toast.makeText(this, "Error al acceder a la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}