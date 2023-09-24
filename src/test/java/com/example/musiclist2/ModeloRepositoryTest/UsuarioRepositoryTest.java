package com.example.musiclist2.ModeloRepositoryTest;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void CreateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Andres");
        usuario.setCorreo("correo123@gmail.com");
        usuario.setContraseña("contraseña");
        usuario.setTipo("pruebaGenero");

        usuarioRepository.save(usuario);

        Usuario savedUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(savedUsuario);
        assertEquals("pruebaGenero", savedUsuario.getTipo());

    }

    @Test
    public void  ReadUsuario(){

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        int cont = 0;
        for(Usuario u : usuarios)
            cont++;
        assertTrue(cont >= 1);
    }

    @Test
    public void UpdateUsuaio(){

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        for(Usuario usuario: usuarios){
            if("Andres".equals(usuario.getNombre())){

                usuario.setTipo("votante");
                usuarioRepository.save(usuario);

            }


            Usuario updatedUsuario =  usuarioRepository.findById(usuario.getId()).orElse(null);
            assertNotNull(updatedUsuario);
            assertEquals("votante", updatedUsuario.getTipo());

        }

    }

    @Test
    public void DeleteUsuario(){

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        for(Usuario usuario: usuarios){
            usuarioRepository.deleteById(usuario.getId());
            Usuario deletedUsuario= usuarioRepository.findById(usuario.getId()).orElse(null);
            assertNull(deletedUsuario);
        }


    }

    @Test
    public void testNombreNoPuedeSerNulo() {
        Usuario usuario = new Usuario();
        usuario.setNombre(null);

        assertThrows(ConstraintViolationException.class, () -> usuarioRepository.save(usuario));
    }


}
