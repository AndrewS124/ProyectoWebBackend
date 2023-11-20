package com.example.musiclist2.rest;

import com.example.musiclist2.dto.UsuariosDTO;
import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Usuario/")
public class UsuarioRest {
    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para obtener todos los usuarios
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> getAllUsuarios() {
        List<UsuariosDTO> usuarios = usuarioService.findAll();

        List<UsuariosDTO> usuariosList = new ArrayList<>();

        usuarios.forEach(usuariosList::add);

        return ResponseEntity.ok(usuariosList);
    }

    // Endpoint para crear un nuevo usuario
    @CrossOrigin
    @PostMapping
    public ResponseEntity<UsuariosDTO> createUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        UsuariosDTO nuevoUsuario = usuarioService.createUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // Endpoint para actualizar un usuario existente
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuariosDTO usuarioDTO) {
        UsuariosDTO usuarioActualizado = usuarioService.updateUsuario(id, usuarioDTO);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un usuario por su ID
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

