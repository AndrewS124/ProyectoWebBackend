<<<<<<< HEAD
package com.example.musiclist2.rest;

import com.example.musiclist2.DTO.UsuarioVotanteDTO;
import com.example.musiclist2.service.UsuarioVotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
=======
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

@RestController
@RequestMapping("/UsuarioVotante/")
public class UsuarioVotanteRest {
    @Autowired
    private UsuarioVotanteService usuarioVotanteService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<UsuarioVotante> createUsuario(@RequestBody UsuarioVotante usuarioVotante) {
        UsuarioVotante nuevoUsuarioVotante = usuarioVotanteService.save(usuarioVotante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioVotante);
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<Iterable<UsuarioVotante>> getAllUsuarios() {
        Iterable<UsuarioVotante> usuariosVotantes = usuarioVotanteService.findAll();
        List<UsuarioVotante> usuariosVotantesList = new ArrayList<>();

        usuariosVotantes.forEach(usuariosVotantesList::add);

        return ResponseEntity.ok(usuariosVotantesList);
    }


    @CrossOrigin
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

    @CrossOrigin
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

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
