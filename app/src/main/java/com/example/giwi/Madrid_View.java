package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Madrid_View extends AppCompatActivity {
    ImageView back;

    Button play_pause_pr;
    Button play_pause_pm;
    Button play_pause_mdp;
    MediaPlayer mp_pr;
    MediaPlayer mp_pm;
    MediaPlayer mp_mdp;

    LinearLayout guardar_madrid;
    boolean estado_boton_vv;
    Button boton_guardar_madrid;
    int drawableResource;
    int notDrawableResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madrid_view);
        play_pause_pr = (Button) findViewById(R.id.play_puente_carlos);
        play_pause_pm = (Button) findViewById(R.id.play_castillo_de_praga);
        play_pause_mdp = (Button) findViewById(R.id.play_museo_del_prado);
        mp_pr = MediaPlayer.create(this, R.raw.palacioreal);
        mp_pm = MediaPlayer.create(this, R.raw.plazamayor);
        mp_mdp = MediaPlayer.create(this, R.raw.elprado);

        estado_boton_vv = true;
        guardar_madrid = (LinearLayout) findViewById(R.id.guardar_madrid);
        boton_guardar_madrid = (Button) findViewById(R.id.boton_guardar_madrid);
        drawableResource = R.drawable.botonguardado;
        notDrawableResource = R.drawable.botonsinguardar;

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();

            }
        });

        guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });
        boton_guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vv == true){
                    boton_guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton_vv = false;
                }else{
                    boton_guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton_vv = true;
                }
            }
        });

        play_pause_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pr.isPlaying()){
                    mp_pr.pause();
                    play_pause_pr.setBackgroundResource(R.drawable.play);

                }else{
                    mp_pr.start();
                    play_pause_pm.setBackgroundResource(R.drawable.play);
                    play_pause_mdp.setBackgroundResource(R.drawable.play);
                    play_pause_pr.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        play_pause_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pm.isPlaying()){
                    mp_pm.pause();
                    play_pause_pm.setBackgroundResource(R.drawable.play);

                }else{
                    mp_pm.start();
                    play_pause_pr.setBackgroundResource(R.drawable.play);
                    play_pause_mdp.setBackgroundResource(R.drawable.play);
                    play_pause_pm.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        play_pause_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_mdp.isPlaying()){
                    mp_mdp.pause();

                    play_pause_mdp.setBackgroundResource(R.drawable.play);

                }else{
                    mp_mdp.start();
                    play_pause_pm.setBackgroundResource(R.drawable.play);
                    play_pause_pr.setBackgroundResource(R.drawable.play);
                    play_pause_mdp.setBackgroundResource(R.drawable.pause);
                }
            }
        });
    }
}