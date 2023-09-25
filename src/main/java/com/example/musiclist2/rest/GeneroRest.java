package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Genero/")
public class GeneroRest {
    @Autowired
    private GeneroService generoService;
    @GetMapping
    private ResponseEntity<Iterable<Genero>> getAllGeneros() {

        List<Genero> generosList = new ArrayList<>();

        try{
            Iterable<Genero> generos = generoService.findAll();


            // Convierte el Iterable en una List
            generos.forEach(generosList::add);

        }catch (Exception e ){
            e.printStackTrace();
        }
        return ResponseEntity.ok(generosList);


    }

}
