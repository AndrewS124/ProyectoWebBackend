<<<<<<< HEAD
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

=======
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

    @Override
    public List<Usuario> findUsuariosByTipo(String tipo) {
        return null;
    }
}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
