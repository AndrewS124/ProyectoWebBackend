package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.GeneroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CancionRepositoryTest {

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Test
    public void CreateCancion() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion");
        cancion.setAutor("Autor");
        cancionRepository.save(cancion);

        Cancion savedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(savedCancion);
        assertEquals("Cancion", savedCancion.getNombreCancion());
        assertEquals("Autor", savedCancion.getAutor());
    }

    @Test
    public void ReadCanciones() {
        Iterable<Cancion> canciones = cancionRepository.findAll();
        int length = 0;
        for (Cancion c : canciones) {
            length++;
        }
        assertTrue(length >= 1);
    }

    @Test
    public void UpdateCancion() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancinAct");
        cancion.setAutor("AutorACt");
        cancionRepository.save(cancion);

        cancion.setNombreCancion("Nuevo nombre");
        cancion.setAutor("Nuevo autor");
        cancionRepository.save(cancion);

        // Verifica que la canción se haya actualizado correctamente
        Cancion updatedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(updatedCancion);
        assertEquals("Nuevo nombre", updatedCancion.getNombreCancion());
        assertEquals("Nuevo autor", updatedCancion.getAutor());
    }

    @Test
    public void DeleteCancion() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("DelCanción");
        cancion.setAutor("DelAutor");
        cancionRepository.save(cancion);

        cancionRepository.deleteById(cancion.getId());

        // Verifica que la canción haya sido eliminada correctamente
        Cancion deletedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNull(deletedCancion);


    }

    @Test
    public void createCancionGenero(){

        Genero genero = new Genero();
        genero.setTipo("prueba");
        generoRepository.save(genero);

        Cancion cancion = new Cancion();
        cancion.setNombreCancion("pruebaCancion");
        cancion.setAutor("pruebaAutor");
        cancion.setGenero(genero);
        cancionRepository.save(cancion);

        Cancion savedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(savedCancion);
        assertEquals("pruebaCancion", savedCancion.getNombreCancion());
        assertEquals("pruebaAutor", savedCancion.getAutor());

        assertNotNull(savedCancion.getGenero());
        assertEquals("prueba", savedCancion.getGenero().getTipo());



    }


}

