package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.service.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UsuarioAdmin/")
public class UsuarioAdminRest {
    @Autowired
    private UsuarioAdminService usuarioAdminService;
    @GetMapping
    private ResponseEntity<Iterable<UsuarioAdmin>> getAllJugadores() {
        Iterable<UsuarioAdmin> equipos = usuarioAdminService.findAll();
        List<UsuarioAdmin> equiposList = new ArrayList<>();

        // Convierte el Iterable en una List
        equipos.forEach(equiposList::add);

        return ResponseEntity.ok(equiposList);
    }

}
