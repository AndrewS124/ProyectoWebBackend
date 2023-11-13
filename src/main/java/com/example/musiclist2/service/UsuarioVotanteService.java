<<<<<<< HEAD

package com.example.musiclist2.service;

import com.example.musiclist2.DTO.UsuarioVotanteDTO;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.UsuarioVotanteRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioVotanteService  {
    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;
    private UsuarioVotanteDTO convertirDTO(UsuarioVotante usuariovotante){
        UsuarioVotanteDTO usuarioVotanteDTO = new UsuarioVotanteDTO();
        BeanUtils.copyProperties(usuariovotante, usuarioVotanteDTO);
        return usuarioVotanteDTO;

    }

   public List<UsuarioVotanteDTO> findAll() {
        List<UsuarioVotante> usuariosVotantes = usuarioVotanteRepository.findAll();
        return usuariosVotantes.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public UsuarioVotanteDTO createUsuarioVotante(UsuarioVotanteDTO usuarioVotanteDTO) {
        UsuarioVotante usuarioVotante = convertirEntidad(usuarioVotanteDTO);
        UsuarioVotante nuevoUsuarioVotante = usuarioVotanteRepository.save(usuarioVotante);
        return convertirDTO(nuevoUsuarioVotante);
    }

    public UsuarioVotanteDTO updateUsuarioVotante(Long id, UsuarioVotanteDTO usuarioVotanteDTO) {
        UsuarioVotante usuarioVotanteExistente = usuarioVotanteRepository.findById(id).orElse(null);

        if (usuarioVotanteExistente != null) {
            BeanUtils.copyProperties(convertirEntidad(usuarioVotanteDTO), usuarioVotanteExistente, "id");
            UsuarioVotante usuarioVotanteActualizado = usuarioVotanteRepository.save(usuarioVotanteExistente);
            return convertirDTO(usuarioVotanteActualizado);
        }

        return null;
    }

    public void deleteUsuarioVotante(Long id) {
        usuarioVotanteRepository.deleteById(id);
    }

    

    private UsuarioVotante convertirEntidad(UsuarioVotanteDTO usuarioDTO) {
        UsuarioVotante usuarioVotante = new UsuarioVotante();
        BeanUtils.copyProperties(usuarioDTO, usuarioVotante);
        return usuarioVotante;
    }
}

=======

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

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
