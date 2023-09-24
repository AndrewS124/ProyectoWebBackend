package com.example.musiclist2.modelo;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    private UsuarioAdmin usuarioAdmin;

    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Cancion> canciones;

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
