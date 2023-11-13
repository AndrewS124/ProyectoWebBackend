package com.example.musiclist2.DTO;

import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.modelo.UsuarioAdmin;

public class CancionDTO {
    private Long id;
    
    private String nombreCancion;

    private String autor;

    private UsuarioAdmin usuarioAdmin;  

    private Genero genero;
    
    

    public CancionDTO(){
        
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }   

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public UsuarioAdmin getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

   

    

    
}
