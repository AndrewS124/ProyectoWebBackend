package com.example.musiclist2.rest;

import com.example.musiclist2.dto.UsuarioVotanteDTO;
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
    @CrossOrigin
    @GetMapping
    public List<UsuarioVotanteDTO> getAllUsuariosVotantes() {
        return usuarioVotanteService.findAll();
    }
    @CrossOrigin
    @PostMapping
    public UsuarioVotanteDTO createUsuarioVotante(@RequestBody UsuarioVotanteDTO usuarioVotanteDTO) {
        return usuarioVotanteService.createUsuarioVotante(usuarioVotanteDTO);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public UsuarioVotanteDTO updateUsuarioVotante(@PathVariable Long id, @RequestBody UsuarioVotanteDTO usuarioVotanteDTO) {
        return usuarioVotanteService.updateUsuarioVotante(id, usuarioVotanteDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteUsuarioVotante(@PathVariable Long id) {
        usuarioVotanteService.deleteUsuarioVotante(id);
    }
}

