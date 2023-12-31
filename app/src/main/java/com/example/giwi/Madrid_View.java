package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Madrid_View extends AppCompatActivity {
    // Declaración de variables para los elementos de la interfaz y los reproductores de audio
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
        setContentView(R.layout.activity_madrid_view);  // Establecer el diseño de la actividad

        // Inicialización de botones y reproductores de audio
        play_pause_pr = (Button) findViewById(R.id.play_puente_carlos);
        play_pause_pm = (Button) findViewById(R.id.play_castillo_de_praga);
        play_pause_mdp = (Button) findViewById(R.id.play_museo_del_prado);
        mp_pr = MediaPlayer.create(this,R.raw.palacioreal);
        mp_pm = MediaPlayer.create(this,R.raw.plazamayor);
        mp_mdp = MediaPlayer.create(this,R.raw.elprado);

        // Inicialización de variables para la opción de guardar
        estado_boton_vv=true;
        guardar_madrid= (LinearLayout)findViewById(R.id.guardar_madrid);
        boton_guardar_madrid = (Button)findViewById(R.id.boton_guardar_madrid);
        drawableResource= R.drawable.i_botonguardado;
        notDrawableResource= R.drawable.i_botonsinguardar;

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            // Pausar la reproducción y volver atrás al hacer clic en el botón de retroceso
            @Override
            public void onClick(View v){
                mp_mdp.pause();
                mp_pr.pause();
                mp_pm.pause();
                onBackPressed();
            }
        });

        // Cambiar el estado y la apariencia del botón de guardar al hacer clic
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

        // Repetir la lógica de clic para mantener consistencia
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

        // Controlar la reproducción/pausa y la apariencia del botón para el Palacio Real
        play_pause_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pr.isPlaying()){
                    mp_pr.pause();
                    mp_pm.pause();
                    mp_mdp.pause();
                    play_pause_pr.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_pr.start();
                    play_pause_pm.setBackgroundResource(R.drawable.i_play);
                    play_pause_mdp.setBackgroundResource(R.drawable.i_play);
                    play_pause_pr.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });

        // Controlar la reproducción/pausa y la apariencia del botón para la Plaza Mayor
        play_pause_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_pm.isPlaying()){
                    mp_pm.pause();
                    mp_pr.pause();
                    mp_mdp.pause();
                    play_pause_pm.setBackgroundResource(R.drawable.i_play);

                }else{
                    mp_pm.start();
                    play_pause_pr.setBackgroundResource(R.drawable.i_play);
                    play_pause_mdp.setBackgroundResource(R.drawable.i_play);
                    play_pause_pm.setBackgroundResource(R.drawable.i_pause);
                }
            }
        });

        // Controlar la reproducción/pausa y la apariencia del botón para el Museo del Prado
        play_pause_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp_mdp.isPlaying()){
                    mp_mdp.pause();
                    mp_pr.pause();
                    mp_pm.pause();
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