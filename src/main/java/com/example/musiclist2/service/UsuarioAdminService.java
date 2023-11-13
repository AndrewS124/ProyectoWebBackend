<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
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
        return usuarioAdminRepository.save(entity);
    }

    @Override
    public <S extends UsuarioAdmin> Iterable<S> saveAll(Iterable<S> entities) {
        return usuarioAdminRepository.saveAll(entities);
    }

    @Override
    public Optional<UsuarioAdmin> findById(Long id) {
        return usuarioAdminRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioAdminRepository.existsById(id);
    }

    @Override
    public Iterable<UsuarioAdmin> findAll() {
        return usuarioAdminRepository.findAll();
    }

    @Override
    public Iterable<UsuarioAdmin> findAllById(Iterable<Long> longs) {
        return usuarioAdminRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return usuarioAdminRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        usuarioAdminRepository.deleteById(id);
    }

    @Override
    public void delete(UsuarioAdmin entity) {
        usuarioAdminRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        usuarioAdminRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioAdmin> entities) {
        usuarioAdminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        usuarioAdminRepository.deleteAll();
    }
}

<<<<<<< HEAD
=======
=======
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
        return usuarioAdminRepository.save(entity);
    }

    @Override
    public <S extends UsuarioAdmin> Iterable<S> saveAll(Iterable<S> entities) {
        return usuarioAdminRepository.saveAll(entities);
    }

    @Override
    public Optional<UsuarioAdmin> findById(Long id) {
        return usuarioAdminRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioAdminRepository.existsById(id);
    }

    @Override
    public Iterable<UsuarioAdmin> findAll() {
        return usuarioAdminRepository.findAll();
    }

    @Override
    public Iterable<UsuarioAdmin> findAllById(Iterable<Long> longs) {
        return usuarioAdminRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return usuarioAdminRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        usuarioAdminRepository.deleteById(id);
    }

    @Override
    public void delete(UsuarioAdmin entity) {
        usuarioAdminRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        usuarioAdminRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioAdmin> entities) {
        usuarioAdminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        usuarioAdminRepository.deleteAll();
    }
}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
