package com.example.musiclist2.service;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancionService implements CancionRepository {
    @Autowired
    CancionRepository cancionRepository;

    @Override
    public <S extends Cancion> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cancion> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Cancion> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    @Override
    public Iterable<Cancion> findAllById(Iterable<Long> longs) {
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
    public void delete(Cancion entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cancion> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
