
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
        return usuarioVotanteRepository.save(entity);
    }

    @Override
    public <S extends UsuarioVotante> Iterable<S> saveAll(Iterable<S> entities) {
        return usuarioVotanteRepository.saveAll(entities);
    }

    @Override
    public Optional<UsuarioVotante> findById(Long id) {
        return usuarioVotanteRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioVotanteRepository.existsById(id);
    }

    @Override
    public Iterable<UsuarioVotante> findAll() {
        return usuarioVotanteRepository.findAll();
    }

    @Override
    public Iterable<UsuarioVotante> findAllById(Iterable<Long> ids) {
        return usuarioVotanteRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return usuarioVotanteRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        usuarioVotanteRepository.deleteById(id);

    }

    @Override
    public void delete(UsuarioVotante entity) {
        usuarioVotanteRepository.delete(entity);
    }


    @Override
    public void deleteAll(Iterable<? extends UsuarioVotante> entities) {
        usuarioVotanteRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        usuarioVotanteRepository.deleteAll();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        usuarioVotanteRepository.deleteAllById(ids);
    }
}

