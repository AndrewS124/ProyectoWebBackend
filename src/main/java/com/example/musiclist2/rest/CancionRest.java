package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Cancion/")
public class CancionRest {
    @Autowired
    private CancionService cancionService;
    @GetMapping
    private ResponseEntity <List<Cancion>> getAllCanciones() {
        Iterable<Cancion> canciones = cancionService.findAll();
        List<Cancion> cancionesList = new ArrayList<>();
       /* int cont=0;
        for (Cancion cancion : canciones) {
            Cancion temp = new Cancion();
            temp.setNombreCancion(cancion.getNombreCancion());
                cancionesList.add(temp);

        }*/

        // Convierte el Iterable en una List
       canciones.forEach(cancionesList::add);

        return ResponseEntity.ok(cancionesList);
    }


}
