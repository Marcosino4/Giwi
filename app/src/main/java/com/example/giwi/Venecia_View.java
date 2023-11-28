package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Venecia_View extends AppCompatActivity {
    Button play_pause_psm;
    Button play_pause_pdr;
    MediaPlayer mp_psm;
    MediaPlayer mp_pdr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venecia_view);
        play_pause_psm= findViewById(R.id.play_piazza_san_marcos);
        play_pause_pdr= findViewById(R.id.play_puente_de_rialto);
        mp_psm = MediaPlayer.create(this, R.raw.prueba1);
        mp_pdr = MediaPlayer.create(this, R.raw.prueba1);
        play_pause_psm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_psm.isPlaying()){
                    mp_psm.pause();
                    play_pause_psm.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_psm.start();
                    play_pause_pdr.setBackgroundResource(R.drawable.i_play);
                    play_pause_psm.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
        play_pause_pdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pdr.isPlaying()){
                    mp_pdr.pause();
                    play_pause_pdr.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_pdr.start();
                    play_pause_psm.setBackgroundResource(R.drawable.i_play);
                    play_pause_pdr.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
    }
}