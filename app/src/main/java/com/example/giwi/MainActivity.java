package com.example.giwi;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        private DrawerLayout drawerLayout;
        private String retrievedEmail, retrievedName, retrievedLastname;
        private TextView userNameMenu, userEmailMenu;
        private FirebaseAuth authProfile;


        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawerLayout = findViewById(R.id.drawer_layout);

            // Obtener referencias a las TextViews en el NavigationView
            NavigationView navigationView =(NavigationView) findViewById(R.id.nav_view);
            View headerView = navigationView.getHeaderView(0);

            //Text views para cambiarles el texto a los datos del usuario
            userNameMenu = (TextView) headerView.findViewById(R.id.user_name);
            userEmailMenu = (TextView) headerView.findViewById(R.id.user_email);

            navigationView.setNavigationItemSelectedListener(this);

            authProfile = FirebaseAuth.getInstance();
            FirebaseUser firebaseUser = authProfile.getCurrentUser();

            String userID = firebaseUser.getUid();
            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Users");

            // Leer datos del usuario desde la base de datos
            referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                    retrievedEmail = firebaseUser.getEmail();
                    retrievedName = readUserDetails.getNombre();
                    retrievedLastname = readUserDetails.getApellido();

                    String nombreCompleto = retrievedName + " " + retrievedLastname;

                    // Mostrar datos de usuario en el NavigationView
                    userNameMenu.setText(nombreCompleto);
                    userEmailMenu.setText(retrievedEmail);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Error cargando los datos", Toast.LENGTH_LONG).show();
                }
            });

            // Configuración del botón de hamburguesa en la barra de herramientas
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                    R.string.close_nav);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_home);
            }

        }

        // Manejar las selecciones de elementos de menú en el cajón de navegación
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Opcion home del menu desplegable
            if (item.getItemId() == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

            //Cerrar sesion
            }else if(item.getItemId() == R.id.nav_logout){
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                authProfile.signOut();

                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);


            }
            // Cerrar el cajón de navegación después de la selección
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

    // Manejar la pulsación del botón "Atrás"
    @Override
        public void onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
}