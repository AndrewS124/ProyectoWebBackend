package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    List<Usuario> findUsuariosByTipo(@Param("tipo") String tipo);

}