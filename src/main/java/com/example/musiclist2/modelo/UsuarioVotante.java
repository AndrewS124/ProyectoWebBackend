<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.modelo;
import javax.persistence.*;




@Entity
public class UsuarioVotante extends Usuario {

    private boolean activacion;

    @OneToOne
    private Cancion votocancion;


    public UsuarioVotante(boolean activacion, Cancion votocancion) {
        this.activacion = activacion;
        this.votocancion = votocancion;
    }

    public UsuarioVotante(String nombre, String correo, String contraseña, boolean autenticacion, boolean activacion, Cancion votocancion) {
        super(nombre, correo, contraseña, autenticacion, "Votante");
        this.activacion = activacion;
        this.votocancion = votocancion;
    }

    public UsuarioVotante() {

    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    public Cancion getVotocancion() {
        return votocancion;
    }

    public void setVotocancion(Cancion votocancion) {
        this.votocancion = votocancion;
    }
}
<<<<<<< HEAD
=======
=======
package com.example.musiclist2.modelo;
import javax.persistence.*;
import java.util.Set;



@Entity
public class UsuarioVotante extends Usuario {

    private boolean activacion;

    @OneToOne
    private Cancion votocancion;


    public UsuarioVotante(boolean activacion, Cancion votocancion) {
        this.activacion = activacion;
        this.votocancion = votocancion;
    }

    public UsuarioVotante(String nombre, String correo, String contraseña, boolean autenticacion, boolean activacion, Cancion votocancion) {
        super(nombre, correo, contraseña, autenticacion, "Votante");
        this.activacion = activacion;
        this.votocancion = votocancion;
    }

    public UsuarioVotante() {

    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    public Cancion getVotocancion() {
        return votocancion;
    }

    public void setVotocancion(Cancion votocancion) {
        this.votocancion = votocancion;
    }
}
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
