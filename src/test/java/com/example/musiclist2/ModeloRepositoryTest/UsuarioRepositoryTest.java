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

        Usuario usuario = new Usuario();
        usuario.setNombre("hola");
        usuario.setCorreo("correo123@gmail.com");
        usuario.setContraseña("contraseña");
        usuario.setTipo("admin");

        usuarioRepository.save(usuario);

        Usuario usuarioLeido = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(usuarioLeido);
        assertEquals("hola", usuarioLeido.getNombre());

    }

    @Test
    public void UpdateUsuaio(){

        // Crear un usuario inicial con tipo "admin"
        Usuario usuario = new Usuario();
        usuario.setNombre("AndresR");
        usuario.setCorreo("correo123@gmail.com");
        usuario.setContraseña("contraseña");
        usuario.setTipo("admin");
        usuarioRepository.save(usuario);

        usuario.setTipo("votante");
        usuarioRepository.save(usuario);

        Usuario updatedUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(updatedUsuario);

        assertEquals("votante", updatedUsuario.getTipo());


    }

    @Test
    public void DeleteUsuario(){

        Usuario usuario = new Usuario();
        usuario.setNombre("pruebaelminar");
        usuario.setCorreo("correo123@gmail.com");
        usuario.setContraseña("contraseña");
        usuario.setTipo("admin");
        usuarioRepository.save(usuario);

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        for(Usuario usr: usuarios){
            if("pruebaelminar".equals(usr.getNombre())){
                usuarioRepository.deleteById(usr.getId());
                Usuario deletedUsuario= usuarioRepository.findById(usr.getId()).orElse(null);
                assertNull(deletedUsuario);
            }

        }


    }

    @Test
    public void testNombreNoPuedeSerNulo() {
        Usuario usuario = new Usuario();
        usuario.setNombre(null);

        assertThrows(ConstraintViolationException.class, () -> usuarioRepository.save(usuario));
    }


}
