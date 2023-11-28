package com.example.giwi;

import static com.example.giwi.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Viena_View extends AppCompatActivity {

    ImageView back;
    LinearLayout guardar_viena;
    boolean estado_boton_vv;
    Button boton_guardar_viena;
    int drawableResource;
    int notDrawableResource;
    Button play_pause_pds;
    MediaPlayer mp_pds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viena_view);
        play_pause_pds= findViewById(R.id.play_palacio_de_schonbrunn);
        mp_pds= MediaPlayer.create(this, R.raw.prueba1);

        estado_boton_vv=true;
        guardar_viena= (LinearLayout)findViewById(R.id.guardar_viena);
        boton_guardar_viena = (Button)findViewById(R.id.boton_guardar_viena);
        drawableResource= R.drawable.i_botonguardado;
        notDrawableResource= R.drawable.i_botonsinguardar;

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();

            }
        });

        guardar_viena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_viena.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_viena.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        boton_guardar_viena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_viena.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_viena.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        play_pause_pds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp_pds.isPlaying()) {
                    mp_pds.pause();
                    play_pause_pds.setBackgroundResource(R.drawable.i_play);

                } else {
                    mp_pds.start();
                    play_pause_pds.setBackgroundResource(R.drawable.i_pause);

                    play_pause_pds.setBackgroundResource(i_play);
                }
            }
        });
    }
}
