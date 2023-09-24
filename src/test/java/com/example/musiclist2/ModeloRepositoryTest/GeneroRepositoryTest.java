package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.GeneroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GeneroRepositoryTest {

    @Autowired
    GeneroRepository generoRepository;

    @Autowired
    CancionRepository cancionRepository;

    @Test
    public void CreateGeneroTest(){


        Genero genero = new Genero();
        genero.setTipo("pruebaGenero");
        generoRepository.save(genero);

        Genero savedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(savedGenero);
        assertEquals("pruebaGenero", savedGenero.getTipo());

    }

    @Test
    public void ReadGeneroTest(){

        Iterable<Genero> generos = generoRepository.findAll();
        int length = 0;
        for (Genero g : generos) {
            length++;
        }
        assertTrue(length >= 1);


    }

    @Test
    public void  UpdateGeneroTest(){

        Iterable<Genero> generos = generoRepository.findAll();
        for (Genero g : generos) {

            g.setTipo("newGenero");
            generoRepository.save(g);

            Genero updatedGenero = generoRepository.findById(g.getId()).orElse(null);
            assertNotNull(updatedGenero);
            assertEquals("newGenero", updatedGenero.getTipo());

        }

    }

    @Test
    public  void DeleteGeneroTest(){

        Genero genero =  new Genero();
        genero.setTipo("music");
        generoRepository.save(genero);

        Iterable<Genero> generos = generoRepository.findAll();
        for(Genero g: generos){
            if(Objects.equals(g.getTipo(), "music"))
                generoRepository.deleteById(g.getId());

        }

        Genero deletedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNull(deletedGenero);

    }

    @Test
    public void CancionesAGenero() {
        Genero genero = new Genero();
        genero.setTipo("Rock");
        generoRepository.save(genero);

        Cancion cancion1 = new Cancion();
        cancion1.setNombreCancion("Canción 1");
        cancion1.setAutor("Autor 1");
        cancion1.setGenero(genero);
        cancionRepository.save(cancion1);

        Cancion cancion2 = new Cancion();
        cancion2.setNombreCancion("Canción 2");
        cancion2.setAutor("Autor 2");
        cancion2.setGenero(genero);
        cancionRepository.save(cancion2);

        Genero loadedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(loadedGenero);
        assertEquals(2, loadedGenero.getCanciones().size());
    }


}
