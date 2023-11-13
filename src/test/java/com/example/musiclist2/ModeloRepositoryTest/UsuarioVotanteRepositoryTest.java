<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.UsuarioVotanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;



import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UsuarioVotanteRepositoryTest {

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    private CancionRepository cancionRepository;

    @Test
    public void CreateUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotantePrueba", "votante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        assertNotNull(usuarioVotante.getId());

        UsuarioVotante savedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(savedUsuarioVotante);
        assertEquals("VotantePrueba", savedUsuarioVotante.getNombre());
        assertEquals("votante@example.com", savedUsuarioVotante.getCorreo());
        assertEquals("password", savedUsuarioVotante.getContraseña());
        assertTrue(savedUsuarioVotante.isAutenticacion());
        assertEquals("Votante", savedUsuarioVotante.getTipo());
        assertTrue(savedUsuarioVotante.isActivacion());
        assertNotNull(savedUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", savedUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", savedUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void ReadUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotantePrueba", "votante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        UsuarioVotante foundUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(foundUsuarioVotante);
        assertEquals("VotantePrueba", foundUsuarioVotante.getNombre());
        assertEquals("votante@example.com", foundUsuarioVotante.getCorreo());
        assertEquals("password", foundUsuarioVotante.getContraseña());
        assertTrue(foundUsuarioVotante.isAutenticacion());
        assertEquals("Votante", foundUsuarioVotante.getTipo());
        assertTrue(foundUsuarioVotante.isActivacion());
        assertNotNull(foundUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", foundUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", foundUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void UpdateUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotanteAct", "votanteact@example.com", "oldpassword", false, false, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        // Actualiza el usuarioVotante
        usuarioVotante.setNombre("NuevoVotante");
        usuarioVotante.setCorreo("nuevovotante@example.com");
        usuarioVotante.setContraseña("newpassword");
        usuarioVotante.setAutenticacion(true);
        usuarioVotante.setActivacion(true);
        usuarioVotanteRepository.save(usuarioVotante);

        UsuarioVotante updatedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(updatedUsuarioVotante);
        assertEquals("NuevoVotante", updatedUsuarioVotante.getNombre());
        assertEquals("nuevovotante@example.com", updatedUsuarioVotante.getCorreo());
        assertEquals("newpassword", updatedUsuarioVotante.getContraseña());
        assertTrue(updatedUsuarioVotante.isAutenticacion());
        assertEquals("Votante", updatedUsuarioVotante.getTipo());
        assertTrue(updatedUsuarioVotante.isActivacion());
        assertNotNull(updatedUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", updatedUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", updatedUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void DeleteUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("DelVotante", "delvotante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        usuarioVotanteRepository.deleteById(usuarioVotante.getId());

        // Verifica que el usuarioVotante haya sido eliminado correctamente
        UsuarioVotante deletedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNull(deletedUsuarioVotante);
    }


    @Test
    public void CreateUsuarioAdminConDatosInvalidos() {
        UsuarioVotante usuarioVotante = new UsuarioVotante();

        assertThrows(ConstraintViolationException.class, () -> {
            usuarioVotanteRepository.save(usuarioVotante);
        });
    }


}























<<<<<<< HEAD
=======
=======
package com.example.musiclist2.ModeloRepositoryTest;


import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.CancionRepository;
import com.example.musiclist2.repositories.UsuarioVotanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UsuarioVotanteRepositoryTest {

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    private CancionRepository cancionRepository;

    @Test
    public void CreateUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotantePrueba", "votante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        assertNotNull(usuarioVotante.getId());

        UsuarioVotante savedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(savedUsuarioVotante);
        assertEquals("VotantePrueba", savedUsuarioVotante.getNombre());
        assertEquals("votante@example.com", savedUsuarioVotante.getCorreo());
        assertEquals("password", savedUsuarioVotante.getContraseña());
        assertTrue(savedUsuarioVotante.isAutenticacion());
        assertEquals("Votante", savedUsuarioVotante.getTipo());
        assertTrue(savedUsuarioVotante.isActivacion());
        assertNotNull(savedUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", savedUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", savedUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void ReadUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotantePrueba", "votante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        UsuarioVotante foundUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(foundUsuarioVotante);
        assertEquals("VotantePrueba", foundUsuarioVotante.getNombre());
        assertEquals("votante@example.com", foundUsuarioVotante.getCorreo());
        assertEquals("password", foundUsuarioVotante.getContraseña());
        assertTrue(foundUsuarioVotante.isAutenticacion());
        assertEquals("Votante", foundUsuarioVotante.getTipo());
        assertTrue(foundUsuarioVotante.isActivacion());
        assertNotNull(foundUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", foundUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", foundUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void UpdateUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("VotanteAct", "votanteact@example.com", "oldpassword", false, false, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        // Actualiza el usuarioVotante
        usuarioVotante.setNombre("NuevoVotante");
        usuarioVotante.setCorreo("nuevovotante@example.com");
        usuarioVotante.setContraseña("newpassword");
        usuarioVotante.setAutenticacion(true);
        usuarioVotante.setActivacion(true);
        usuarioVotanteRepository.save(usuarioVotante);

        UsuarioVotante updatedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNotNull(updatedUsuarioVotante);
        assertEquals("NuevoVotante", updatedUsuarioVotante.getNombre());
        assertEquals("nuevovotante@example.com", updatedUsuarioVotante.getCorreo());
        assertEquals("newpassword", updatedUsuarioVotante.getContraseña());
        assertTrue(updatedUsuarioVotante.isAutenticacion());
        assertEquals("Votante", updatedUsuarioVotante.getTipo());
        assertTrue(updatedUsuarioVotante.isActivacion());
        assertNotNull(updatedUsuarioVotante.getVotocancion());
        assertEquals("CancionPrueba", updatedUsuarioVotante.getVotocancion().getNombreCancion());
        assertEquals("AutorPrueba", updatedUsuarioVotante.getVotocancion().getAutor());
    }

    @Test
    public void DeleteUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("CancionPrueba");
        cancion.setAutor("AutorPrueba");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("DelVotante", "delvotante@example.com", "password", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        usuarioVotanteRepository.deleteById(usuarioVotante.getId());

        // Verifica que el usuarioVotante haya sido eliminado correctamente
        UsuarioVotante deletedUsuarioVotante = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assertNull(deletedUsuarioVotante);
    }


    @Test
    public void CreateUsuarioAdminConDatosInvalidos() {
        UsuarioVotante usuarioVotante = new UsuarioVotante();

        assertThrows(ConstraintViolationException.class, () -> {
            usuarioVotanteRepository.save(usuarioVotante);
        });
    }


}























>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
