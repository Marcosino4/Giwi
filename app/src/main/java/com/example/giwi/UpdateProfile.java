package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giwi.Database.DatabaseAux;

public class UpdateProfile extends AppCompatActivity {

    private DatabaseAux aux;
    private SQLiteDatabase db;
    private String email;
    private EditText editName, editLastname, editEmail;




    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        aux = new DatabaseAux(UpdateProfile.this);
        db = aux.getWritableDatabase();

        Intent intent = getIntent();
        email = intent.getStringExtra("email");

        editName = findViewById(R.id.editName);
        editLastname = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);

        Cursor n = db.rawQuery("SELECT name FROM users WHERE email ='" + email +"'", null);
        if(n.moveToFirst()){
            String nombreDb = n.getString(n.getColumnIndex("name"));
            editName.setText(nombreDb);
        }

        Cursor ln = db.rawQuery("SELECT lastName FROM users WHERE email ='" + email +"'", null);
        if(ln.moveToFirst()){
            String apellidoDb = ln.getString(ln.getColumnIndex("lastName"));
            editLastname.setText(apellidoDb);
        }

        Cursor e = db.rawQuery("SELECT email FROM users WHERE email ='" + email +"'", null);
        if(e.moveToFirst()){
            String emailDb = e.getString(e.getColumnIndex("email"));
            editEmail.setText(emailDb);
        }


    }


    public void Update(View view){
        String newName = editName.getText().toString();
        String newLastname = editLastname.getText().toString();
        String newEmail = editEmail.getText().toString();

        if(db != null && !newName.isEmpty() && !newLastname.isEmpty() && !newEmail.isEmpty()){
            ContentValues values = new ContentValues();

            values.put("name", newName);
            values.put("lastName", newLastname);
            values.put("email", newEmail);

            long res = db.update("users", values,"email= '"+email+"'", null);
            if(res >= 0){
                Toast.makeText(this, "Actualizado correctamente", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this, "Fallo al actualizar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }else{
            Toast.makeText(this, "Error al acceder a la base de datos", Toast.LENGTH_LONG).show();

        }

        Intent nIntent = new Intent(UpdateProfile.this, Login.class);
        startActivity(nIntent);
        finish();


    }
}