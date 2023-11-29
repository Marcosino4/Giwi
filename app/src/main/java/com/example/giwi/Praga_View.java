package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Praga_View extends AppCompatActivity {
    ImageView back;

    Button play_pause_pc;
    Button play_pause_cdp;
    MediaPlayer mp_pc;
    MediaPlayer mp_cdp;

    LinearLayout guardar_praga;
    boolean estado_boton_vv;
    Button boton_guardar_praga;
    int drawableResource;
    int notDrawableResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praga_view);
        play_pause_pc=(Button)findViewById(R.id.play_puente_carlos);
        play_pause_cdp=(Button)findViewById(R.id.play_castillo_de_praga);
        mp_pc=MediaPlayer.create(this,R.raw.puentecarlos);
        mp_cdp=MediaPlayer.create(this,R.raw.castillodepraga);

        estado_boton_vv=true;
        guardar_praga= (LinearLayout)findViewById(R.id.guardar_praga);
        boton_guardar_praga = (Button)findViewById(R.id.boton_guardar_praga);
        drawableResource= R.drawable.i_botonguardado;
        notDrawableResource= R.drawable.i_botonsinguardar;

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mp_pc.pause();
                mp_cdp.pause();
                onBackPressed();

            }
        });
        guardar_praga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_praga.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_praga.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        boton_guardar_praga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_praga.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_praga.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        play_pause_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_pc.isPlaying()){
                    mp_pc.pause();
                    play_pause_pc.setBackgroundResource(R.drawable.i_play);
                }else{
                    mp_pc.start();
                    play_pause_cdp.setBackgroundResource(R.drawable.i_play);
                    play_pause_pc.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
        play_pause_cdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_cdp.isPlaying()){
                    mp_cdp.pause();
                    play_pause_cdp.setBackgroundResource(R.drawable.i_play);
                }else{
                    mp_cdp.start();
                    play_pause_pc.setBackgroundResource(R.drawable.i_play);
                    play_pause_cdp.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
    }
}