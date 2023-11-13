<<<<<<< HEAD
package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.GeneroRepository;
import com.example.musiclist2.repositories.UsuarioAdminRepository;
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

    @Autowired
    private UsuarioAdminRepository usuarioAdminRepository;

    @Test
    public void CreateCancion() {

        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion");
        cancion.setAutor("Autor");
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancion.setGenero(genero);
        cancionRepository.save(cancion);

        assertNotNull(cancion.getId());

        // Verifica que la canción se haya guardado correctamente
        Cancion savedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(savedCancion);
        assertEquals("Cancion", savedCancion.getNombreCancion());
        assertEquals("Autor", savedCancion.getAutor());
    }

    @Test
    public void ReadCanciones() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancion.setGenero(genero);
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancionRepository.save(cancion);

        // Verifica que la canción se pueda encontrar por su ID
        Cancion foundCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(foundCancion);
        assertEquals("CancionPrueba", foundCancion.getNombreCancion());
        assertEquals("AutorPrueba", foundCancion.getAutor());
    }

    @Test
    public void UpdateCancion() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionAct");
        cancion.setAutor("AutorAct");
        cancion.setGenero(genero);
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancionRepository.save(cancion);

        // Actualiza la canción
        cancion.setNombreCancion("Nuevo nombre");
        cancion.setAutor("Nuevo autor");
        cancionRepository.save(cancion);

        Cancion updatedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(updatedCancion);
        assertEquals("Nuevo nombre", updatedCancion.getNombreCancion());
        assertEquals("Nuevo autor", updatedCancion.getAutor());
    }

    @Test
    public void DeleteCancion() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion");
        cancion.setAutor("Autor");
        cancion.setGenero(genero);
        cancionRepository.save(cancion);

        // elimina la canción
        cancionRepository.deleteById(cancion.getId());

        Cancion deletedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNull(deletedCancion);
    }

    @Test
    public void pruebaRelacionCancionesGenero() {
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

        // Verificar que las canciones se relacionen correctamente con el género
        Genero generoConCanciones = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(generoConCanciones);
        assertEquals("GeneroConCanciones", generoConCanciones.getTipo());
    }

}


=======
package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.GeneroRepository;
import com.example.musiclist2.repositories.UsuarioAdminRepository;
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

    @Autowired
    private UsuarioAdminRepository usuarioAdminRepository;

    @Test
    public void CreateCancion() {

        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion");
        cancion.setAutor("Autor");
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancion.setGenero(genero);
        cancionRepository.save(cancion);

        assertNotNull(cancion.getId());

        // Verifica que la canción se haya guardado correctamente
        Cancion savedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(savedCancion);
        assertEquals("Cancion", savedCancion.getNombreCancion());
        assertEquals("Autor", savedCancion.getAutor());
    }

    @Test
    public void ReadCanciones() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancion.setGenero(genero);
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancionRepository.save(cancion);

        // Verifica que la canción se pueda encontrar por su ID
        Cancion foundCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(foundCancion);
        assertEquals("CancionPrueba", foundCancion.getNombreCancion());
        assertEquals("AutorPrueba", foundCancion.getAutor());
    }

    @Test
    public void UpdateCancion() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionAct");
        cancion.setAutor("AutorAct");
        cancion.setGenero(genero);
        cancion.setUsuarioAdmin(usuarioAdmin);
        cancionRepository.save(cancion);

        // Actualiza la canción
        cancion.setNombreCancion("Nuevo nombre");
        cancion.setAutor("Nuevo autor");
        cancionRepository.save(cancion);

        Cancion updatedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNotNull(updatedCancion);
        assertEquals("Nuevo nombre", updatedCancion.getNombreCancion());
        assertEquals("Nuevo autor", updatedCancion.getAutor());
    }

    @Test
    public void DeleteCancion() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);
        Genero genero = new Genero();
        genero.setTipo("GeneroPrueba");
        generoRepository.save(genero);
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion");
        cancion.setAutor("Autor");
        cancion.setGenero(genero);
        cancionRepository.save(cancion);

        // elimina la canción
        cancionRepository.deleteById(cancion.getId());

        Cancion deletedCancion = cancionRepository.findById(cancion.getId()).orElse(null);
        assertNull(deletedCancion);
    }

    @Test
    public void pruebaRelacionCancionesGenero() {
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

        // Verificar que las canciones se relacionen correctamente con el género
        Genero generoConCanciones = generoRepository.findById(genero.getId()).orElse(null);
        assertNotNull(generoConCanciones);
        assertEquals("GeneroConCanciones", generoConCanciones.getTipo());
    }

}


>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
