package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {

    List<UsuarioVotante> findAll();
}
