package com.example.giwi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "SignUp";
    private EditText nameEdit, lastNameEdit, emailEdit, passEdit;
    private String nameString, lastNameString, emailString, passString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Seleccionar los Edits
        setContentView(R.layout.signin);
        nameEdit = findViewById(R.id.nameSingin);
        lastNameEdit = findViewById(R.id.lastNameSingin);
        emailEdit = findViewById(R.id.emailSingin);
        passEdit= findViewById(R.id.passSingin);

    }

    public void changeToLogin(View view){
        Intent nIntent = new Intent(SignIn.this, Login.class);
        startActivity(nIntent);
    }

    public void signup(View view){

        //Pasar lo que hay en el textview a string
        nameString = nameEdit.getText().toString();
        lastNameString = lastNameEdit.getText().toString();
        emailString = emailEdit.getText().toString();
        passString = passEdit.getText().toString();

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
                                try{
                                    throw task.getException();
                                }catch(FirebaseAuthWeakPasswordException e){
                                    passEdit.setError("Tu contraseña es muy debil, porfavor usa una mezcla de numeros y letras mayusculas y minusculas");
                                    passEdit.requestFocus();
                                }catch(FirebaseAuthInvalidCredentialsException e){
                                    emailEdit.setError("Tu email no es valido o ya está en uso");
                                    emailEdit.requestFocus();
                                }catch(FirebaseAuthUserCollisionException e){
                                    passEdit.setError("El usuario ya está registrado con estas credenciales");
                                    passEdit.requestFocus();
                                }catch(Exception e){
                                    Log.e(TAG, e.getMessage());
                                    Toast.makeText(SignIn.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
        }else{
            Toast.makeText(SignIn.this, "Porfavor, rellene los campos", Toast.LENGTH_LONG).show();
        }
    }
}