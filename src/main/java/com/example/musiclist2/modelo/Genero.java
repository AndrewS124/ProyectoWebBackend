package com.example.musiclist2.modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;


    @OneToMany(mappedBy = "genero") // Establece la relación uno a muchos con Cancion
    @JsonManagedReference
    private List<Cancion> canciones;

    @ManyToOne
    private UsuarioAdmin usuarioAdmin;

    public Genero() {
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


}
