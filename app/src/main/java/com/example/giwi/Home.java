package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    Button guardar_madrid;
    Button guardar_praga;
    Button guardar_viena;
    Button guardar_venecia;
    boolean estado_boton_m;
    boolean estado_boton_p;
    boolean estado_boton_vi;
    boolean estado_boton_ve;
    LinearLayout ly_m;
    LinearLayout ly_p;
    LinearLayout ly_vi;
    LinearLayout ly_ve;

    int drawableResource;
    int notDrawableResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        estado_boton_m =true;
        estado_boton_p =true;
        estado_boton_vi =true;
        estado_boton_ve =true;
        guardar_madrid = findViewById(R.id.guardar_madrid);
        guardar_praga = findViewById(R.id.guardar_praga);
        guardar_viena = findViewById(R.id.guardar_viena);
        guardar_venecia = findViewById(R.id.guardar_venecia);
        drawableResource= R.drawable.botonguardado;
        notDrawableResource= R.drawable.botonsinguardar;
        ly_m=(LinearLayout)findViewById(R.id.madrid_contenedor);
        ly_p=(LinearLayout)findViewById(R.id.praga_contenedor);
        ly_vi=(LinearLayout)findViewById(R.id.viena_contenedor);
        ly_ve=(LinearLayout)findViewById(R.id.venecia_contenedor);
        ly_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Madrid_View.class);
                startActivity(i);
            }
        });
        ly_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Praga_View.class);
                startActivity(i);
            }
        });
        ly_vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Viena_View.class);
                startActivity(i);
            }
        });
        ly_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Venecia_View.class);
                startActivity(i);
            }
        });
        guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                

                if(estado_boton_m == true){
                    guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton_m = false;
                }else{
                    guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton_m = true;
                }
            }
        });
        guardar_praga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_p == true){
                    guardar_praga.setBackgroundResource(drawableResource);
                    estado_boton_p = false;
                }else{
                    guardar_praga.setBackgroundResource(notDrawableResource);
                    estado_boton_p = true;
                }
            }
        });
        guardar_viena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vi == true){
                    guardar_viena.setBackgroundResource(drawableResource);
                    estado_boton_vi = false;
                }else{
                    guardar_viena.setBackgroundResource(notDrawableResource);
                    estado_boton_vi = true;
                }
            }
        });
        guardar_venecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_ve == true){
                    guardar_venecia.setBackgroundResource(drawableResource);
                    estado_boton_ve = false;
                }else{
                    guardar_venecia.setBackgroundResource(notDrawableResource);
                    estado_boton_ve = true;
                }
            }
        });

    }
}