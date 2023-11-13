package com.example.musiclist2.service;

import com.example.musiclist2.DTO.UsuariosDTO;
import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService  {
    @Autowired
    UsuarioRepository usuarioRepository;

   private UsuariosDTO convertirDTO(Usuario usuario){
        UsuariosDTO usuariosDTO= new UsuariosDTO();
        usuariosDTO.setId(usuario.getId());
        usuariosDTO.setCorreo(usuario.getCorreo());
        usuariosDTO.setNombre(usuario.getNombre());
        usuariosDTO.setTipo(usuario.getTipo());
        usuariosDTO.setContraseña(usuario.getContraseña());
        usuariosDTO.setautentificacion((usuario.isAutenticacion()));

        return usuariosDTO;

    }

    public List<UsuariosDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
    public UsuariosDTO createUsuario(UsuariosDTO usuarioDTO) {
        Usuario usuario = convertirEntidad(usuarioDTO);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return convertirDTO(nuevoUsuario);
    }

    public UsuariosDTO updateUsuario(Long id, UsuariosDTO usuarioDTO) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = convertirEntidad(usuarioDTO);
            usuario.setId(id);
            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            return convertirDTO(usuarioActualizado);
        }

        return null; 
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    private Usuario convertirEntidad(UsuariosDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setTipo(usuarioDTO.getTipo());
        usuario.setContraseña(usuarioDTO.getContrasena());
        return usuario;
    }

  
   

   
    
   
}

