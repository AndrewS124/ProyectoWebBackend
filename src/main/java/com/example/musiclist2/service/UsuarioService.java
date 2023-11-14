package com.example.musiclist2.service;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioRepository {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public List<Usuario> findUsuariosByTipo(String tipo) {
        return null;
    }

    @Override
    public Boolean existsByCorreo(String correo) {
        return null;
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return Optional.empty();
    }

    @Override
    public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities) {
        return usuarioRepository.saveAll(entities);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Iterable<Usuario> findAllById(Iterable<Long> longs) {
        return usuarioRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteAllById(Collections.singletonList(id));
    }

    @Override
    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        usuarioRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Usuario> entities) {
        usuarioRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }


}

