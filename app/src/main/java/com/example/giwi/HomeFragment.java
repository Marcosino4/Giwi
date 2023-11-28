package com.example.giwi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeFragment extends Fragment {
    Button guardar_madrid;
    Button guardar_praga;
    Button guardar_viena;
    Button guardar_venecia;
    boolean estado_boton_m;
    boolean estado_boton_p;
    boolean estado_boton_vi;
    boolean estado_boton_ve;
    LinearLayout ly_m;
    LinearLayout ly_p;
    LinearLayout ly_vi;
    LinearLayout ly_ve;

    int drawableResource;
    int notDrawableResource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        estado_boton_m = true;
        estado_boton_p = true;
        estado_boton_vi = true;
        estado_boton_ve = true;
        guardar_madrid = rootView.findViewById(R.id.guardar_madrid);
        guardar_praga = rootView.findViewById(R.id.guardar_praga);
        guardar_viena = rootView.findViewById(R.id.guardar_viena);
        guardar_venecia = rootView.findViewById(R.id.guardar_venecia);
        drawableResource = R.drawable.i_botonguardado;
        notDrawableResource = R.drawable.i_botonsinguardar;
        ly_m = rootView.findViewById(R.id.madrid_contenedor);
        ly_p = rootView.findViewById(R.id.praga_contenedor);
        ly_vi = rootView.findViewById(R.id.viena_contenedor);
        ly_ve = rootView.findViewById(R.id.venecia_contenedor);
        ly_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Madrid_View.class);
                startActivity(i);
            }
        });
        ly_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Praga_View.class);
                startActivity(i);
            }
        });
        ly_vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Viena_View.class);
                startActivity(i);
            }
        });
        ly_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Venecia_View.class);
                startActivity(i);
            }
        });
        guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado_boton_m) {
                    guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton_m = false;
                } else {
                    guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton_m = true;
                }
            }
        });
        guardar_praga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado_boton_p) {
                    guardar_praga.setBackgroundResource(drawableResource);
                    estado_boton_p = false;
                } else {
                    guardar_praga.setBackgroundResource(notDrawableResource);
                    estado_boton_p = true;
                }
            }
        });
        guardar_viena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado_boton_vi) {
                    guardar_viena.setBackgroundResource(drawableResource);
                    estado_boton_vi = false;
                } else {
                    guardar_viena.setBackgroundResource(notDrawableResource);
                    estado_boton_vi = true;
                }
            }
        });
        guardar_venecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado_boton_ve) {
                    guardar_venecia.setBackgroundResource(drawableResource);
                    estado_boton_ve = false;
                } else {
                    guardar_venecia.setBackgroundResource(notDrawableResource);
                    estado_boton_ve = true;
                }
            }
        });
        return  rootView;
    }
}