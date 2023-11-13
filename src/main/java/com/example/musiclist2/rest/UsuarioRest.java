<<<<<<< HEAD
package com.example.musiclist2.rest;
import com.example.musiclist2.DTO.UsuariosDTO;
import com.example.musiclist2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


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
=======
package com.example.musiclist2.rest;

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


    @CrossOrigin
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<Iterable<Usuario>> getAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioService.findAll();
        List<Usuario> usuariosList = new ArrayList<>();

        usuarios.forEach(usuariosList::add);

        return ResponseEntity.ok(usuariosList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.findById(id);

        if (!usuarioExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuario.setId(id);
        Usuario usuarioActualizado = usuarioService.save(usuario);

        return ResponseEntity.ok(usuarioActualizado);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioExistente = usuarioService.findById(id);

        if (!usuarioExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.delete(usuarioExistente.get());
        return ResponseEntity.noContent().build();
    }


}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
