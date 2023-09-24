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
    UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    CancionRepository cancionRepository;

    @Test
    public void createUsuarioVotante() {
        Cancion cancion = new Cancion();
        cancion.setNombreCancion("Cancion1");
        cancion.setAutor("Artista1");
        cancionRepository.save(cancion);

        UsuarioVotante usuarioVotante = new UsuarioVotante("Nombre", "correo@example.com", "contraseña", true, true, cancion);
        usuarioVotanteRepository.save(usuarioVotante);

        UsuarioVotante usuarioVotanteGuardado = usuarioVotanteRepository.findById(usuarioVotante.getId()).orElse(null);
        assert usuarioVotanteGuardado != null;
        assertNotNull(usuarioVotanteGuardado);
        assertEquals("Nombre", usuarioVotanteGuardado.getNombre());
        assertTrue(usuarioVotanteGuardado.isActivacion());
        assertEquals(cancion.getId(), usuarioVotanteGuardado.getVotocancion().getId());
    }

    @Test
    public void ReadUsuarioAdmin(){

        Iterable<UsuarioVotante> usuarioVotantes = usuarioVotanteRepository.findAll();

        int cont = 0;
        for(UsuarioVotante ua : usuarioVotantes)
            cont++;
        assertTrue(cont >= 1);


    }

    @Test
    public void UpdateUsuarioAdmin(){

        Iterable<UsuarioVotante> usuarioVotantes = usuarioVotanteRepository.findAll();

        for(UsuarioVotante uv : usuarioVotantes){
            if("Nombre".equals(uv.getNombre())){
                uv.setNombre("Andres");
                usuarioVotanteRepository.save(uv);

                UsuarioVotante updateUsuarioVotante =  usuarioVotanteRepository.findById(uv.getId()).orElse(null);
                assert updateUsuarioVotante != null;
                assertNotNull(updateUsuarioVotante);
                assertEquals("Andres", updateUsuarioVotante.getNombre());

            }
        }


    }

    @Test
    public void DeleteUsuarioVotante(){

        Iterable<UsuarioVotante> usuarioVotantes = usuarioVotanteRepository.findAll();

        for(UsuarioVotante uv : usuarioVotantes){
            if("Andres".equals(uv.getNombre())){

                usuarioVotanteRepository.deleteById(uv.getId());

                UsuarioVotante deletedUsuarioV =  usuarioVotanteRepository.findById(uv.getId()).orElse(null);
                assert deletedUsuarioV != null;
                assertNull(deletedUsuarioV);

            }
        }

    }

    @Test
    public void CreateUsuarioAdminConDatosInvalidos() {
        UsuarioVotante usuarioVotante = new UsuarioVotante();

        assertThrows(ConstraintViolationException.class, () -> {
            usuarioVotanteRepository.save(usuarioVotante);
        });
    }

}
