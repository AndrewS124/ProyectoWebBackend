
package com.example.musiclist2.service;

import com.example.musiclist2.dto.UsuarioVotanteDTO;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.UsuarioVotanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

