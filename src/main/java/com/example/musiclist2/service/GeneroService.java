
package com.example.musiclist2.service;


import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService implements GeneroRepository {
    @Autowired
    GeneroRepository generoRepository;
    @Override
    public <S extends Genero> S save(S entity) {
        return generoRepository.save(entity);
    }

    @Override
    public <S extends Genero> Iterable<S> saveAll(Iterable<S> entities) {
        return generoRepository.saveAll(entities);
    }

    @Override
    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return generoRepository.existsById(id);
    }

    @Override
    public Iterable<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public Iterable<Genero> findAllById(Iterable<Long> longs) {
        return generoRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return generoRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public void delete(Genero entity) {
        generoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        generoRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Genero> entities) {
        generoRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        generoRepository.deleteAll();
    }


   /* public List<Genero> getGenerosConCanciones() {
        return (List<Genero>) generoRepository.findAll(); // Esto recupera todos los géneros con sus canciones asociadas debido a la relación bidireccional.
    }*/


}

