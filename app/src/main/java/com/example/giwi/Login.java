package com.example.giwi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {

    // Elementos de la interfaz
    private TextView emailTextView, passTextView;

    private String emailString, passString;
    private FirebaseAuth authProfile;

    // Etiqueta para mensajes de registro (logging) (Me lo dijo un indio)
    private static final String TAG = "Login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailTextView = findViewById(R.id.emailLogin);
        passTextView = findViewById(R.id.passLogin);

        // Obtener la instancia de FirebaseAuth.
        authProfile = FirebaseAuth.getInstance();
    }

    //Cambiar al inicio de sesión
    public void changeToSignin(View view){
        Intent nIntent = new Intent(Login.this, SignIn.class);
        startActivity(nIntent);
    }

    //Funcion que realiza el login
    @SuppressLint("Range")
    public void logIn(View view){
        //Datos del textview a texto
        emailString = emailTextView.getText().toString();
        passString = passTextView.getText().toString();

        //Si todos los campos están rellenos, entonces
        if(!emailString.isEmpty() && !passString.isEmpty()){

            //Logear un perfil según su correo y contraseña
            authProfile.signInWithEmailAndPassword(emailString, passString).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //Si se ha logrado realizar de forma satisfactoria
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this, "Iniciando sesión", Toast.LENGTH_LONG).show();
                        //Cuando inicia sesion hace el intent para cambiar al home
                        Intent intent = new Intent(Login.this, MainActivity.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                        finish();


                        //Si no, excepciones del inicio de sesión
                    }else{
                        try{
                            throw task.getException();
                        }catch(FirebaseAuthInvalidUserException e){
                            emailTextView.setError("Su usuario no existe");
                            emailTextView.requestFocus();
                        }catch(FirebaseAuthInvalidCredentialsException e){
                            emailTextView.setError("Credenciales invalidas, porfavor intentelo de nuevo");
                            emailTextView.requestFocus();
                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        Toast.makeText(Login.this, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
                    }
                }
            });


        //Si no estan todos los campos completos
        }else{
            Toast.makeText(Login.this, "porfavor, complete todos los campos", Toast.LENGTH_LONG).show();
        }



    }

}







