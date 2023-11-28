package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Madrid_View extends AppCompatActivity {
    Button play_pause_pr;
    Button play_pause_pm;
    Button play_pause_mdp;
    MediaPlayer mp_pr;
    MediaPlayer mp_pm;
    MediaPlayer mp_mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madrid_view);
        play_pause_pr = findViewById(R.id.play_puente_carlos);
        play_pause_pm = findViewById(R.id.play_castillo_de_praga);
        play_pause_mdp = findViewById(R.id.play_museo_del_prado);
        mp_pr = MediaPlayer.create(this,R.raw.prueba1);
        mp_pm = MediaPlayer.create(this,R.raw.prueba1);
        mp_mdp = MediaPlayer.create(this,R.raw.prueba1);
        play_pause_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pr.isPlaying()){
                    mp_pr.pause();
                    play_pause_pr.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_pr.start();
                    play_pause_pm.setBackgroundResource(R.drawable.i_play);
                    play_pause_mdp.setBackgroundResource(R.drawable.i_play);
                    play_pause_pr.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
        play_pause_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pm.isPlaying()){
                    mp_pm.pause();
                    play_pause_pm.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_pm.start();
                    play_pause_pr.setBackgroundResource(R.drawable.i_play);
                    play_pause_mdp.setBackgroundResource(R.drawable.i_play);
                    play_pause_pm.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
        play_pause_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_mdp.isPlaying()){
                    mp_mdp.pause();

                    play_pause_mdp.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_mdp.start();
                    play_pause_pm.setBackgroundResource(R.drawable.i_play);
                    play_pause_pr.setBackgroundResource(R.drawable.i_play);
                    play_pause_mdp.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
    }
}