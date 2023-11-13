package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.UsuarioVotante;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioVotanteRepository extends CrudRepository<UsuarioVotante, Long> {
    List<UsuarioVotante> findAll();
}
