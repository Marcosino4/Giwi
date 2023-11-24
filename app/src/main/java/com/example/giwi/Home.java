package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button guardar_madrid;
    boolean estado_boton;
    int drawableResource;
    int notDrawableResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        estado_boton =true;
        guardar_madrid = findViewById(R.id.guardar_madrid);
        drawableResource= R.drawable.botonguardado;
        notDrawableResource= R.drawable.botonsinguardar;
        guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton == true){
                    guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton = false;
                }else{
                    guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton = true;
                }
            }
        });
    }
}