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

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioAdminRepositoryTest {


    @Autowired
    private UsuarioAdminRepository usuarioAdminRepository;

    @Test
    public void CreateUsuarioAdmin() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin("Nombre", "correo@example.com", "contraseña", true);
        usuarioAdminRepository.save(usuarioAdmin);

        UsuarioAdmin usuarioLeido = usuarioAdminRepository.findById(usuarioAdmin.getId()).orElse(null);
        assertNotNull(usuarioLeido);
        assertEquals("Nombre", usuarioLeido.getNombre());
        assertEquals("correo@example.com", usuarioLeido.getCorreo());
    }

    @Test
    public void ReadUsuarioAdmin(){

        Iterable<UsuarioAdmin> usuarioAdmins = usuarioAdminRepository.findAll();

        int cont = 0;
        for(UsuarioAdmin ua : usuarioAdmins)
            cont++;
        assertTrue(cont >= 1);


    }

    @Test
    public void UpdateUsuarioAdmin(){

        Iterable<UsuarioAdmin> usuarioAdmins = usuarioAdminRepository.findAll();

        for(UsuarioAdmin ua : usuarioAdmins){
            if("Nombre".equals(ua.getNombre())){
                ua.setNombre("Andres");
                usuarioAdminRepository.save(ua);

                UsuarioAdmin updateUsuarioAdmin =  usuarioAdminRepository.findById(ua.getId()).orElse(null);
                assert updateUsuarioAdmin != null;
                assertNotNull(updateUsuarioAdmin);
                assertEquals("Andres", updateUsuarioAdmin.getNombre());

            }
        }


    }

    @Test
    public void DeleteUsuarioAdmin(){

        Iterable<UsuarioAdmin> usuarioAdmins = usuarioAdminRepository.findAll();

        for(UsuarioAdmin ua : usuarioAdmins){
            if("Andres".equals(ua.getNombre())){

                usuarioAdminRepository.deleteById(ua.getId());

                UsuarioAdmin deletedUsuarioAdmin =  usuarioAdminRepository.findById(ua.getId()).orElse(null);
                assert deletedUsuarioAdmin != null;
                assertNull(deletedUsuarioAdmin);

            }
        }

    }

    @Test
    public void CreateUsuarioAdminConDatosInvalidos() {
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin();

        // Usamos assertThrows para verificar que se genera una excepción de restricción de integridad de datos
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioAdminRepository.save(usuarioAdmin);
        });
    }

}
