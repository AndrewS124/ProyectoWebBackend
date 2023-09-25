package com.example.musiclist2.service;

import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.repositories.UsuarioAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioAdminService implements UsuarioAdminRepository {
    @Autowired
    UsuarioAdminRepository usuarioAdminRepository;
    @Override
    public <S extends UsuarioAdmin> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UsuarioAdmin> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UsuarioAdmin> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<UsuarioAdmin> findAll() {
        return usuarioAdminRepository.findAll();
    }

    @Override
    public Iterable<UsuarioAdmin> findAllById(Iterable<Long> longs) {
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
    public void delete(UsuarioAdmin entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioAdmin> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
