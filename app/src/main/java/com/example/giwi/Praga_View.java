package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Praga_View extends AppCompatActivity {
    Button play_pause_pc;
    Button play_pause_cdp;
    MediaPlayer mp_pc;
    MediaPlayer mp_cdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praga_view);
        play_pause_pc=(Button)findViewById(R.id.play_puente_carlos);
        play_pause_cdp=(Button)findViewById(R.id.play_castillo_de_praga);
        mp_pc=MediaPlayer.create(this,R.raw.prueba1);
        mp_cdp=MediaPlayer.create(this,R.raw.prueba1);

        play_pause_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_pc.isPlaying()){
                    mp_pc.pause();
                    play_pause_pc.setBackgroundResource(R.drawable.play);
                }else{
                    mp_pc.start();
                    play_pause_cdp.setBackgroundResource(R.drawable.play);
                    play_pause_pc.setBackgroundResource(R.drawable.pause);
                }
            }
        });
        play_pause_cdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_cdp.isPlaying()){
                    mp_cdp.pause();
                    play_pause_cdp.setBackgroundResource(R.drawable.play);
                }else{
                    mp_cdp.start();
                    play_pause_pc.setBackgroundResource(R.drawable.play);
                    play_pause_cdp.setBackgroundResource(R.drawable.pause);
                }
            }
        });
    }
}