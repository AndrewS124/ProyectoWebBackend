<<<<<<< HEAD
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {
    List<UsuarioVotante> findAll();
}
=======
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {


}
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
