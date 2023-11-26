package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        play_pause_pr = (Button) findViewById(R.id.play_palacio_real);
        play_pause_pm = (Button) findViewById(R.id.play_plaza_mayor);
        play_pause_mdp = (Button) findViewById(R.id.play_museo_del_prado);
        mp_pr = MediaPlayer.create(this,R.raw.prueba1);
        mp_pm = MediaPlayer.create(this,R.raw.prueba1);
        mp_mdp = MediaPlayer.create(this,R.raw.prueba1);
        play_pause_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pr.isPlaying()){
                    mp_pr.pause();
                    play_pause_pr.setBackgroundResource(R.drawable.pause);
                }else{
                    mp_pr.start();
                }
            }
        });
        play_pause_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pm.isPlaying()){
                    mp_pm.pause();
                    play_pause_pm.setBackgroundResource(R.drawable.pause);
                }else{
                    mp_pm.start();
                }
            }
        });
        play_pause_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_mdp.isPlaying()){
                    mp_mdp.pause();
                    play_pause_mdp.setBackgroundResource(R.drawable.pause);
                }else{
                    mp_mdp.start();
                }
            }
        });
    }
}