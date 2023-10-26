
package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Genero/")
public class GeneroRest {

    @Autowired
    private GeneroService generoService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Genero> createCancion(@RequestBody Genero genero) {
        Genero nuevoGenero = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGenero);
    }


    @CrossOrigin
    @GetMapping
    private ResponseEntity <List<Genero>> getAllGeneros() {
        Iterable<Genero> generos = generoService.findAll();
        List<Genero> generoList = new ArrayList<>();

        generos.forEach(generoList::add);

        return ResponseEntity.ok(generoList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateCancion(@PathVariable Long id, @RequestBody Genero genero) {
        Optional<Genero> generoExistente = generoService.findById(id);

        if (!generoExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        genero.setId(id); // Aseguramos que la ID de la canción sea la misma que la proporcionada en la URL.
        Genero generoActualizado = generoService.save(genero);

        return ResponseEntity.ok(generoActualizado);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        Optional<Genero> generoExistente = generoService.findById(id);

        if (generoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        generoService.delete(generoExistente.get());
        return ResponseEntity.noContent().build();
    }

}

