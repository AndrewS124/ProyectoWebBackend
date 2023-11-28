package com.example.musiclist2.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class UsuariosDTO  {
    private Long id;
    private String nombre;
    private String correo;
    private String tipo;
    private String contraseña;
    private boolean autentificacion;


    public UsuariosDTO() {
    }

    public UsuariosDTO(Long id, String nombre, String correo, String tipo, String contraseña, boolean autentificacion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña=contraseña;
        this.autentificacion=autentificacion;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setContraseña(String Contraseña){
        this.contraseña=Contraseña;
    }
    public String getContrasena(){
        return  this.contraseña;
    }
    public void setautentificacion(boolean autentificacion){
        this.autentificacion=autentificacion;
    }
    public boolean getautentificacion(){
        return this.autentificacion;
    }
}


