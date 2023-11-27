package com.example.giwi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.example.giwi.Database.DatabaseAux;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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

    public void signup(){
        TextView nameTextView = findViewById(R.id.nameSingin);
        TextView lastNameTextView = findViewById(R.id.lastNameSingin);
        TextView emailTextView = findViewById(R.id.emailSingin);
        TextView passTextView = findViewById(R.id.passSingin);

        //Pasar lo que hay en el textview a string
        String nameString = nameTextView.getText().toString();
        String lastNameString = lastNameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String passString = passTextView.getText().toString();

        if(!nameString.isEmpty() && !lastNameString.isEmpty() && !emailString.isEmpty() && !passString.isEmpty()){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(emailString, passString).addOnCompleteListener(SignIn.this,
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //Toast para indicar que el usuario ha sido registrado
                                Toast.makeText(SignIn.this, "Usuario Registrado", Toast.LENGTH_LONG).show();
                                FirebaseUser user = auth.getCurrentUser();

                                //Mandar correo de verificacion
                                user.sendEmailVerification();

                                //Una vez registrado el usuario, accede a la pantalla de home
                                Intent intent =  new Intent(SignIn.this, Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                        Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                                finish();

                            }else{
                                Toast.makeText(SignIn.this, "Error: Usuario no registrado", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(SignIn.this, "Porfavor, rellene los campos", Toast.LENGTH_LONG).show();
        }
    }
}