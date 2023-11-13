<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {
    List<UsuarioVotante> findAll();
}
<<<<<<< HEAD
=======
=======
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {


}
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
