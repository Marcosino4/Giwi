package com.example.giwi;

import com.google.firebase.database.DatabaseReference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReadWriteUserDetails {
    private String nombre, apellido;

    private ArrayList<String> listaFavoritos;

    public ReadWriteUserDetails() {
    }

    public ReadWriteUserDetails(String nombre, String apellido, ArrayList<String> listaFavoritos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaFavoritos=listaFavoritos;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<String> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(ArrayList<String> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }
}
