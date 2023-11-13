<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.rest;

import com.example.musiclist2.DTO.CancionDTO;
import com.example.musiclist2.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Cancion/")
public class CancionRest {
    @Autowired
    private CancionService cancionService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<CancionDTO> createCancion(@RequestBody CancionDTO dto) {
        CancionDTO nuevaCancion = cancionService.createCancion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<CancionDTO>> getAllCanciones() {
        Iterable<CancionDTO> canciones = cancionService.findAll();
        List<CancionDTO> cancionesList = new ArrayList<>();

        canciones.forEach(cancionesList::add);

        return ResponseEntity.ok(cancionesList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<CancionDTO> updateCancion(@PathVariable Long id, @RequestBody CancionDTO cancion) {
        Optional<CancionDTO> cancionExistente = cancionService.findById(id);

        if (!cancionExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cancion.setId(id); // Aseguramos que la ID de la canción sea la misma que la proporcionada en la URL.

        CancionDTO cancionActualizada = cancionService.updateCancion(id,cancion);

        return ResponseEntity.ok(cancionActualizada);
    }



    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long id) {
        Optional<CancionDTO> cancionExistente = cancionService.findById(id);

        if (!cancionExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cancionService.deleteCancion(id);
        return ResponseEntity.noContent().build();
    }



}

<<<<<<< HEAD
=======
=======
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
@CrossOrigin(origins = "*")
@RequestMapping("/Cancion/")
public class CancionRest {
    @Autowired
    private CancionService cancionService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Cancion> createCancion(@RequestBody Cancion cancion) {
        Cancion nuevaCancion = cancionService.save(cancion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<Cancion>> getAllCanciones() {
        Iterable<Cancion> canciones = cancionService.findAll();
        List<Cancion> cancionesList = new ArrayList<>();

        canciones.forEach(cancionesList::add);

        return ResponseEntity.ok(cancionesList);
    }

    @CrossOrigin
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



    @CrossOrigin
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

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
