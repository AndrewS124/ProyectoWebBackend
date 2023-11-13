<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    List<Usuario> findUsuariosByTipo(@Param("tipo") String tipo);

<<<<<<< HEAD
=======
=======
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends CrudRepository <Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    List<Usuario> findUsuariosByTipo(@Param("tipo") String tipo);

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
}