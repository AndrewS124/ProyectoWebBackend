package com.example.musiclist2.ModeloRepositoryTest;

import com.example.musiclist2.modelo.UsuarioAdmin;
import com.example.musiclist2.repositories.UsuarioAdminRepository;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioAdminRepositoryTest {

    @Autowired
    private UsuarioAdminRepository usuarioAdminRepository;

    @Test
    public void CreateUsuarioAdmin() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("AdminPrueba", "admin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);

        assertNotNull(usuarioAdmin.getId());

        // Verifica que el usuarioAdmin se haya guardado correctamente
        UsuarioAdmin savedUsuarioAdmin = usuarioAdminRepository.findById(usuarioAdmin.getId()).orElse(null);
        assertNotNull(savedUsuarioAdmin);
        assertEquals("AdminPrueba", savedUsuarioAdmin.getNombre());
        assertEquals("admin@example.com", savedUsuarioAdmin.getCorreo());
        assertEquals("password", savedUsuarioAdmin.getContraseña());
        assertTrue(savedUsuarioAdmin.isAutenticacion());
        assertEquals("Admin", savedUsuarioAdmin.getTipo());
    }

    @Test
    public void ReadUsuarioAdmin() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("AdminPrueba", "admin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);

        // Verifica que el usuarioAdmin se pueda encontrar por su ID
        UsuarioAdmin foundUsuarioAdmin = usuarioAdminRepository.findById(usuarioAdmin.getId()).orElse(null);
        assertNotNull(foundUsuarioAdmin);
        assertEquals("AdminPrueba", foundUsuarioAdmin.getNombre());
        assertEquals("admin@example.com", foundUsuarioAdmin.getCorreo());
        assertEquals("password", foundUsuarioAdmin.getContraseña());
        assertTrue(foundUsuarioAdmin.isAutenticacion());
        assertEquals("Admin", foundUsuarioAdmin.getTipo());
    }

    @Test
    public void UpdateUsuarioAdmin() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("AdminAct", "adminact@example.com", "oldpassword", false);
        usuarioAdminRepository.save(usuarioAdmin);

        // Actualiza el usuarioAdmin
        usuarioAdmin.setNombre("NuevoAdmin");
        usuarioAdmin.setCorreo("nuevoadmin@example.com");
        usuarioAdmin.setContraseña("newpassword");
        usuarioAdmin.setAutenticacion(true);
        usuarioAdminRepository.save(usuarioAdmin);

        // Verifica que el usuarioAdmin se haya actualizado correctamente
        UsuarioAdmin updatedUsuarioAdmin = usuarioAdminRepository.findById(usuarioAdmin.getId()).orElse(null);
        assertNotNull(updatedUsuarioAdmin);
        assertEquals("NuevoAdmin", updatedUsuarioAdmin.getNombre());
        assertEquals("nuevoadmin@example.com", updatedUsuarioAdmin.getCorreo());
        assertEquals("newpassword", updatedUsuarioAdmin.getContraseña());
        assertTrue(updatedUsuarioAdmin.isAutenticacion());
        assertEquals("Admin", updatedUsuarioAdmin.getTipo());
    }

    @Test
    public void DeleteUsuarioAdmin() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("DelAdmin", "deladmin@example.com", "password", true);
        usuarioAdminRepository.save(usuarioAdmin);

        usuarioAdminRepository.deleteById(usuarioAdmin.getId());

        // Verifica que el usuarioAdmin haya sido eliminado correctamente
        UsuarioAdmin deletedUsuarioAdmin = usuarioAdminRepository.findById(usuarioAdmin.getId()).orElse(null);
        assertNull(deletedUsuarioAdmin);
    }


    @Test
    public void CrearUsuarioAdminInvalido() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin();

        assertThrows(ConstraintViolationException.class, () -> {
            usuarioAdminRepository.save(usuarioAdmin);
        });
    }


}

