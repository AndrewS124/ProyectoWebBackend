package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Cancion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancionRepository extends CrudRepository<Cancion, Long> {
     List<Cancion> findAll();
}