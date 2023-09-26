
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
        return cancionRepository.save(entity);
    }

    @Override
    public <S extends Cancion> Iterable<S> saveAll(Iterable<S> entities) {
        return cancionRepository.saveAll(entities);
    }

    @Override
    public Optional<Cancion> findById(Long id) {
        return cancionRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cancionRepository.existsById(id);
    }

    @Override
    public Iterable<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    @Override
    public Iterable<Cancion> findAllById(Iterable<Long> longs) {
        return cancionRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return cancionRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        cancionRepository.deleteById(id);
    }

    @Override
    public void delete(Cancion entity) {
        cancionRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        cancionRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Cancion> entities) {
        cancionRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        cancionRepository.deleteAll();
    }
}

