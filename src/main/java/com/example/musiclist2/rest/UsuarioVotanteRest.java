package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.service.UsuarioVotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UsuarioVotante/")
public class UsuarioVotanteRest {
    @Autowired
    private UsuarioVotanteService usuarioVotanteService;
    @GetMapping
    private ResponseEntity<Iterable<UsuarioVotante>> getAllUsuarios() {
        Iterable<UsuarioVotante> usuariosVotantes = usuarioVotanteService.findAll();
        List<UsuarioVotante> usuariosVotantesList = new ArrayList<>();

        // Convierte el Iterable en una List
        usuariosVotantes.forEach(usuariosVotantesList::add);

        return ResponseEntity.ok(usuariosVotantesList);
    }
}
