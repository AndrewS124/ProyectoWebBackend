package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.service.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UsuarioAdmin/")
public class UsuarioAdminRest {
    @Autowired
    private UsuarioAdminService usuarioAdminService;

    @PostMapping
    public ResponseEntity<UsuarioAdmin> createUsuario(@RequestBody UsuarioAdmin usuarioAdmin) {
        UsuarioAdmin nuevoUsuarioAdmin = usuarioAdminService.save(usuarioAdmin);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioAdmin);
    }


    @GetMapping
    private ResponseEntity<Iterable<UsuarioAdmin>> getAllJugadores() {
        Iterable<UsuarioAdmin> equipos = usuarioAdminService.findAll();
        List<UsuarioAdmin> equiposList = new ArrayList<>();

        equipos.forEach(equiposList::add);

        return ResponseEntity.ok(equiposList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAdmin> updateUsuarioAdmin(@PathVariable Long id, @RequestBody UsuarioAdmin usuarioAdmin) {
        Optional<UsuarioAdmin> usuarioAdminExistente = usuarioAdminService.findById(id);

        if (!usuarioAdminExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioAdmin.setId(id);
        UsuarioAdmin usuarioAdminActualizado = usuarioAdminService.save(usuarioAdmin);

        return ResponseEntity.ok(usuarioAdminActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioAdmin(@PathVariable Long id) {
        Optional<UsuarioAdmin> usuarioAdminExistente = usuarioAdminService.findById(id);

        if (usuarioAdminExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarioAdminService.delete(usuarioAdminExistente.get());
        return ResponseEntity.noContent().build();
    }

}

