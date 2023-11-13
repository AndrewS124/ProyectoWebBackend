<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.modelo;
import javax.persistence.*;



@Entity
public class UsuarioAdmin extends Usuario {


    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String nombre, String correo, String contraseña, boolean autenticacion) {
        super(nombre, correo, contraseña, autenticacion, "Admin");
    }

<<<<<<< HEAD
=======
=======
package com.example.musiclist2.modelo;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class UsuarioAdmin extends Usuario {


    public UsuarioAdmin() {
    }

    public UsuarioAdmin(String nombre, String correo, String contraseña, boolean autenticacion) {
        super(nombre, correo, contraseña, autenticacion, "Admin");
    }

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
}