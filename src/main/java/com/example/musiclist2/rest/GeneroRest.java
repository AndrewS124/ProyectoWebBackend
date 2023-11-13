<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7

package com.example.musiclist2.rest;

import com.example.musiclist2.DTO.CancionDTO;
import com.example.musiclist2.DTO.GeneroDTO;
import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.service.CancionService;
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
    public ResponseEntity<GeneroDTO> createGenero(@RequestBody GeneroDTO genero) {
        GeneroDTO nuevoGenero = generoService.createGenero(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGenero);
    }


    @CrossOrigin
    @GetMapping
    private ResponseEntity <List<GeneroDTO>> getAllGeneros() {
        Iterable<GeneroDTO> generos = generoService.findAll();
        List<GeneroDTO> generoList = new ArrayList<>();

        generos.forEach(generoList::add);

        return ResponseEntity.ok(generoList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> updateCancion(@PathVariable Long id, @RequestBody GeneroDTO genero) {
        Optional<GeneroDTO> generoExistente = generoService.findById(id);

        if (!generoExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        genero.setId(id); // Aseguramos que la ID de la canción sea la misma que la proporcionada en la URL.
        GeneroDTO generoActualizado = generoService.updateGenero(id,genero);

        return ResponseEntity.ok(generoActualizado);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        Optional<GeneroDTO> generoExistente = generoService.findById(id);

        if (generoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        generoService.deleteGenero(id);
        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD
    @CrossOrigin
=======

>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
    @GetMapping("/{id}/canciones")
    public ResponseEntity<List<Cancion>> getCancionesPorGenero(@PathVariable Long id) {
        Optional<GeneroDTO> generoOptional = generoService.findById(id);

        if (!generoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        GeneroDTO genero = generoOptional.get();
        List<Cancion> canciones = genero.getCanciones(); // Obtiene la lista de canciones asociadas al género

        return ResponseEntity.ok(canciones);
    }

}

<<<<<<< HEAD
=======
=======

package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.service.CancionService;
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

    @GetMapping("/{id}/canciones")
    public ResponseEntity<List<Cancion>> getCancionesPorGenero(@PathVariable Long id) {
        Optional<Genero> generoOptional = generoService.findById(id);

        if (!generoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Genero genero = generoOptional.get();
        List<Cancion> canciones = genero.getCanciones(); // Obtiene la lista de canciones asociadas al género

        return ResponseEntity.ok(canciones);
    }

}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
