package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Venecia_View extends AppCompatActivity {
    Button play_pause_psm;
    Button play_pause_pdr;
    MediaPlayer mp_psm;
    MediaPlayer mp_pdr;

    LinearLayout guardar_venecia;
    boolean estado_boton_vv;
    Button boton_guardar_venecia;
    int drawableResource;
    int notDrawableResource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venecia_view);
        play_pause_psm= (Button) findViewById(R.id.play_piazza_san_marcos);
        play_pause_pdr= (Button) findViewById(R.id.play_puente_de_rialto);
        mp_psm = MediaPlayer.create(this, R.raw.prueba1);
        mp_pdr = MediaPlayer.create(this, R.raw.prueba1);

        estado_boton_vv=true;
        guardar_venecia= (LinearLayout)findViewById(R.id.guardar_venecia);
        boton_guardar_venecia = (Button)findViewById(R.id.boton_guardar_venecia);
        drawableResource= R.drawable.botonguardado;
        notDrawableResource= R.drawable.botonsinguardar;
        guardar_venecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_venecia.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_venecia.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        boton_guardar_venecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_venecia.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_venecia.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        play_pause_psm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_psm.isPlaying()){
                    mp_psm.pause();
                    play_pause_psm.setBackgroundResource(R.drawable.play);

                }else{
                    mp_psm.start();
                    play_pause_pdr.setBackgroundResource(R.drawable.play);
                    play_pause_psm.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        play_pause_pdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pdr.isPlaying()){
                    mp_pdr.pause();
                    play_pause_pdr.setBackgroundResource(R.drawable.play);

                }else{
                    mp_pdr.start();
                    play_pause_psm.setBackgroundResource(R.drawable.play);
                    play_pause_pdr.setBackgroundResource(R.drawable.pause);
                }
            }
        });
    }
}