package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
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
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        estado_boton_m =true;
        estado_boton_p =true;
        estado_boton_vi =true;
        estado_boton_ve =true;
        guardar_madrid = findViewById(R.id.guardar_madrid);
        guardar_praga = findViewById(R.id.guardar_praga);
        guardar_viena = findViewById(R.id.guardar_viena);
        guardar_venecia = findViewById(R.id.guardar_venecia);
        drawableResource= R.drawable.i_botonguardado;
        notDrawableResource= R.drawable.i_botonsinguardar;
        ly_m=(LinearLayout)findViewById(R.id.madrid_contenedor);
        ly_p=(LinearLayout)findViewById(R.id.praga_contenedor);
        ly_vi=(LinearLayout)findViewById(R.id.viena_contenedor);
        ly_ve=(LinearLayout)findViewById(R.id.venecia_contenedor);
        ly_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Madrid_View.class);
                startActivity(i);
            }
        });
        ly_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Praga_View.class);
                startActivity(i);
            }
        });
        ly_vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Viena_View.class);
                startActivity(i);
            }
        });
        ly_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Venecia_View.class);
                startActivity(i);
            }
        });
        guardar_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_m == true){
                    guardar_madrid.setBackgroundResource(drawableResource);
                    estado_boton_m = false;
                }else{
                    guardar_madrid.setBackgroundResource(notDrawableResource);
                    estado_boton_m = true;
                }
            }
        });
        guardar_praga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_p == true){
                    guardar_praga.setBackgroundResource(drawableResource);
                    estado_boton_p = false;
                }else{
                    guardar_praga.setBackgroundResource(notDrawableResource);
                    estado_boton_p = true;
                }
            }
        });
        guardar_viena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_vi == true){
                    guardar_viena.setBackgroundResource(drawableResource);
                    estado_boton_vi = false;
                }else{
                    guardar_viena.setBackgroundResource(notDrawableResource);
                    estado_boton_vi = true;
                }
            }
        });
        guardar_venecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estado_boton_ve == true){
                    guardar_venecia.setBackgroundResource(drawableResource);
                    estado_boton_ve = false;
                }else{
                    guardar_venecia.setBackgroundResource(notDrawableResource);
                    estado_boton_ve = true;
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}