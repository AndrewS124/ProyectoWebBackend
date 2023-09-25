package com.example.musiclist2.service;

import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.UsuarioVotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioVotanteService implements UsuarioVotanteRepository {
    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;
    @Override
    public <S extends UsuarioVotante> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UsuarioVotante> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UsuarioVotante> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<UsuarioVotante> findAll() {
        return usuarioVotanteRepository.findAll();
    }

    @Override
    public Iterable<UsuarioVotante> findAllById(Iterable<Long> longs) {
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
    public void delete(UsuarioVotante entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioVotante> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
