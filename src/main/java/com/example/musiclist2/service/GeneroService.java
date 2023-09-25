package com.example.musiclist2.service;


import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneroService implements GeneroRepository {
    @Autowired
    GeneroRepository generoRepository;
    @Override
    public <S extends Genero> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Genero> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Genero> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public Iterable<Genero> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Genero entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Genero> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
