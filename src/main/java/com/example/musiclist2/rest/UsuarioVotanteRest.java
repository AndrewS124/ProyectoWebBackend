package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.service.UsuarioVotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/UsuarioVotante/")
public class UsuarioVotanteRest {
    @Autowired
    private UsuarioVotanteService usuarioVotanteService;


    @PostMapping
    public ResponseEntity<UsuarioVotante> createUsuario(@RequestBody UsuarioVotante usuarioVotante) {
        UsuarioVotante nuevoUsuarioVotante = usuarioVotanteService.save(usuarioVotante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioVotante);
    }


    @GetMapping
    private ResponseEntity<Iterable<UsuarioVotante>> getAllUsuarios() {
        Iterable<UsuarioVotante> usuariosVotantes = usuarioVotanteService.findAll();
        List<UsuarioVotante> usuariosVotantesList = new ArrayList<>();

        usuariosVotantes.forEach(usuariosVotantesList::add);

        return ResponseEntity.ok(usuariosVotantesList);
    }



    @PutMapping("/{id}")
    public ResponseEntity<UsuarioVotante> updateUsuario(@PathVariable Long id, @RequestBody UsuarioVotante usuarioVotante) {
        Optional<UsuarioVotante> usuarioVotanteExistente = usuarioVotanteService.findById(id);

        if (usuarioVotanteExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarioVotante.setId(id);
        UsuarioVotante usuarioAdminActualizado = usuarioVotanteService.save(usuarioVotante);

        return ResponseEntity.ok(usuarioAdminActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioVotante(@PathVariable Long id) {
        Optional<UsuarioVotante> usuarioVotanteExistente = usuarioVotanteService.findById(id);

        if (usuarioVotanteExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarioVotanteService.delete(usuarioVotanteExistente.get());
        return ResponseEntity.noContent().build();
    }

}

