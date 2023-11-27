package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Viena_View extends AppCompatActivity {
    Button play_pause_pds;
    MediaPlayer mp_pds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viena_view);
        play_pause_pds= (Button) findViewById(R.id.play_palacio_de_schonbrunn);
        mp_pds= MediaPlayer.create(this, R.raw.prueba1);

        play_pause_pds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp_pds.isPlaying()) {
                    mp_pds.pause();
                    play_pause_pds.setBackgroundResource(R.drawable.i_play);

                } else {
                    mp_pds.start();
                    play_pause_pds.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });
    }
}
