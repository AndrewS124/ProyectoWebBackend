<<<<<<< HEAD
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
    private GeneroRepository generoRepository;

    @Autowired
    private CancionRepository cancionRepository;

    @Test
    public void CreateGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);


        // Verifica que el género se haya guardado correctamente
        Genero savedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(savedGenero);
        assertEquals("GeneroPrueba", savedGenero.getTipo());
    }

    @Test
    public void ReadGeneros() {
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);

        // Verifica que el género se pueda encontrar por su ID
        Genero foundGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(foundGenero);
        assertEquals("GeneroPrueba", foundGenero.getTipo());
    }

    @Test
    public void UpdateGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroAct");
        generoRepository.save(genero);

        // Actualiza el género
        genero.setTipo("NuevoTipo");
        generoRepository.save(genero);

        // Verifica que el género se haya actualizado correctamente
        Genero updatedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(updatedGenero);
        assertEquals("NuevoTipo", updatedGenero.getTipo());
    }

    @Test
    public void DeleteGenero() {
        Genero genero = new Genero();
        genero.setTipo("DelGenero");
        generoRepository.save(genero);

        generoRepository.deleteById(genero.getId());

        // Verifica que el género haya sido eliminado correctamente
        Genero deletedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNull(deletedGenero);
    }

    @Test
    public void CancionesAGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroConCanciones");
        generoRepository.save(genero);

        Cancion cancion1 = new Cancion();
        cancion1.setNombreCancion("Cancion1");
        cancion1.setAutor("Autor1");
        cancion1.setGenero(genero);
        cancionRepository.save(cancion1);

        Cancion cancion2 = new Cancion();
        cancion2.setNombreCancion("Cancion2");
        cancion2.setAutor("Autor2");
        cancion2.setGenero(genero);
        cancionRepository.save(cancion2);

        // Verifica que las canciones se hayan relacionado correctamente con el género
        Genero generoConCanciones = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(generoConCanciones);
        assertEquals("GeneroConCanciones", generoConCanciones.getTipo());
    }



}


=======
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
    private GeneroRepository generoRepository;

    @Autowired
    private CancionRepository cancionRepository;

    @Test
    public void CreateGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);


        // Verifica que el género se haya guardado correctamente
        Genero savedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(savedGenero);
        assertEquals("GeneroPrueba", savedGenero.getTipo());
    }

    @Test
    public void ReadGeneros() {
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);

        // Verifica que el género se pueda encontrar por su ID
        Genero foundGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(foundGenero);
        assertEquals("GeneroPrueba", foundGenero.getTipo());
    }

    @Test
    public void UpdateGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroAct");
        generoRepository.save(genero);

        // Actualiza el género
        genero.setTipo("NuevoTipo");
        generoRepository.save(genero);

        // Verifica que el género se haya actualizado correctamente
        Genero updatedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(updatedGenero);
        assertEquals("NuevoTipo", updatedGenero.getTipo());
    }

    @Test
    public void DeleteGenero() {
        Genero genero = new Genero();
        genero.setTipo("DelGenero");
        generoRepository.save(genero);

        generoRepository.deleteById(genero.getId());

        // Verifica que el género haya sido eliminado correctamente
        Genero deletedGenero = generoRepository.findById(genero.getId()).orElse(null);
        assertNull(deletedGenero);
    }

    @Test
    public void CancionesAGenero() {
        Genero genero = new Genero();
        genero.setTipo("GeneroConCanciones");
        generoRepository.save(genero);

        Cancion cancion1 = new Cancion();
        cancion1.setNombreCancion("Cancion1");
        cancion1.setAutor("Autor1");
        cancion1.setGenero(genero);
        cancionRepository.save(cancion1);

        Cancion cancion2 = new Cancion();
        cancion2.setNombreCancion("Cancion2");
        cancion2.setAutor("Autor2");
        cancion2.setGenero(genero);
        cancionRepository.save(cancion2);

        // Verifica que las canciones se hayan relacionado correctamente con el género
        Genero generoConCanciones = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(generoConCanciones);
        assertEquals("GeneroConCanciones", generoConCanciones.getTipo());
    }



}


>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
