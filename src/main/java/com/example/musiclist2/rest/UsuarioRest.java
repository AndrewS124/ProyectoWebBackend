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



    @GetMapping
    private ResponseEntity<Iterable<Usuario>> getAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioService.findAll();
        List<Usuario> usuariosList = new ArrayList<>();

        usuarios.forEach(usuariosList::add);

        return ResponseEntity.ok(usuariosList);
    }


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

