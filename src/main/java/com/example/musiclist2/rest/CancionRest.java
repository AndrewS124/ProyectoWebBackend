package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cancion/")
public class CancionRest {
    @Autowired
    private CancionService cancionService;

    @PostMapping
    public ResponseEntity<Cancion> createCancion(@RequestBody Cancion cancion) {
        Cancion nuevaCancion = cancionService.save(cancion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
    }


    @GetMapping
    private ResponseEntity<List<Cancion>> getAllCanciones() {
        Iterable<Cancion> canciones = cancionService.findAll();
        List<Cancion> cancionesList = new ArrayList<>();

        canciones.forEach(cancionesList::add);

        return ResponseEntity.ok(cancionesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        Optional<Cancion> cancionExistente = cancionService.findById(id);

        if (!cancionExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cancion.setId(id); // Aseguramos que la ID de la canción sea la misma que la proporcionada en la URL.
        Cancion cancionActualizada = cancionService.save(cancion);

        return ResponseEntity.ok(cancionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long id) {
        Optional<Cancion> cancionExistente = cancionService.findById(id);

        if (!cancionExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cancionService.delete(cancionExistente.get());
        return ResponseEntity.noContent().build();
    }



}

