<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;



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
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }


}
<<<<<<< HEAD
=======
=======
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
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
