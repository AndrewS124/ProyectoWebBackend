package com.example.musiclist2.modelo;
import javax.persistence.*;



@Entity
public class UsuarioAdmin extends Usuario {


    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String nombre, String correo, String contraseña, boolean autenticacion) {
        super(nombre, correo, contraseña, autenticacion, "Admin");
    }

}