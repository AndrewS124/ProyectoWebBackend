package com.example.musiclist2.dto;

import java.util.List;

import com.example.musiclist2.modelo.Cancion;


public class GeneroDTO {
    private Long id;
    private String tipo;
    private List<Cancion> canciones;
    public GeneroDTO(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public List<Cancion> getCanciones() {
        return canciones;
    }
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
   

}
