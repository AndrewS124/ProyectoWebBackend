package com.example.musiclist2.ModeloRepositoryTest;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void CreateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioPrueba");
        usuario.setCorreo("usuario@example.com");
        usuario.setContraseña("password");
        usuario.setAutenticacion(true);
        usuario.setTipo("TipoPrueba");
        usuarioRepository.save(usuario);

        assertNotNull(usuario.getId());

        // Verifica que el usuario se haya guardado correctamente
        Usuario savedUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(savedUsuario);
        assertEquals("UsuarioPrueba", savedUsuario.getNombre());
        assertEquals("usuario@example.com", savedUsuario.getCorreo());
        assertEquals("password", savedUsuario.getContraseña());
        assertTrue(savedUsuario.isAutenticacion());
        assertEquals("TipoPrueba", savedUsuario.getTipo());
    }

    @Test
    public void ReadUsuarios() {
        // Crea un usuario de prueba y guárdalo
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioPrueba");
        usuario.setCorreo("usuario@example.com");
        usuario.setContraseña("password");
        usuario.setAutenticacion(true);
        usuario.setTipo("TipoPrueba");
        usuarioRepository.save(usuario);

        // Verifica que el usuario se pueda encontrar por su ID
        Usuario foundUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(foundUsuario);
        assertEquals("UsuarioPrueba", foundUsuario.getNombre());
        assertEquals("usuario@example.com", foundUsuario.getCorreo());
        assertEquals("password", foundUsuario.getContraseña());
        assertTrue(foundUsuario.isAutenticacion());
        assertEquals("TipoPrueba", foundUsuario.getTipo());
    }

    @Test
    public void UpdateUsuario() {
        // Crea un usuario de prueba y guárdalo
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioAct");
        usuario.setCorreo("usuarioact@example.com");
        usuario.setContraseña("oldpassword");
        usuario.setAutenticacion(false);
        usuario.setTipo("TipoAct");
        usuarioRepository.save(usuario);

        // Actualiza el usuario
        usuario.setNombre("NuevoNombre");
        usuario.setCorreo("nuevoemail@example.com");
        usuario.setContraseña("newpassword");
        usuario.setAutenticacion(true);
        usuario.setTipo("NuevoTipo");
        usuarioRepository.save(usuario);

        // Verifica que el usuario se haya actualizado correctamente
        Usuario updatedUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNotNull(updatedUsuario);
        assertEquals("NuevoNombre", updatedUsuario.getNombre());
        assertEquals("nuevoemail@example.com", updatedUsuario.getCorreo());
        assertEquals("newpassword", updatedUsuario.getContraseña());
        assertTrue(updatedUsuario.isAutenticacion());
        assertEquals("NuevoTipo", updatedUsuario.getTipo());
    }

    @Test
    public void DeleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("DelUsuario");
        usuario.setCorreo("delusuario@example.com");
        usuario.setContraseña("password");
        usuario.setAutenticacion(true);
        usuario.setTipo("TipoPrueba");
        usuarioRepository.save(usuario);

        usuarioRepository.deleteById(usuario.getId());

        Usuario deletedUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        assertNull(deletedUsuario);
    }

    @Test
    public void UsuariosPorTipo() {
        // Crea varios usuarios de prueba con diferentes tipos
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario1");
        usuario1.setCorreo("usuario1@example.com");
        usuario1.setContraseña("password1");
        usuario1.setAutenticacion(true);
        usuario1.setTipo("Tipo1");
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario2");
        usuario2.setCorreo("usuario2@example.com");
        usuario2.setContraseña("password2");
        usuario2.setAutenticacion(true);
        usuario2.setTipo("Tipo2");
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Usuario3");
        usuario3.setCorreo("usuario3@example.com");
        usuario3.setContraseña("password3");
        usuario3.setAutenticacion(true);
        usuario3.setTipo("Tipo1");
        usuarioRepository.save(usuario3);

        List<Usuario> usuariosTipo1 = usuarioRepository.findUsuariosByTipo("Tipo1");
        List<Usuario> usuariosTipo2 = usuarioRepository.findUsuariosByTipo("Tipo2");
        int contT1=0;
        int contT2=0;

        for(Usuario usuario: usuariosTipo1){
            if("Tipo1".equals(usuario.getTipo())){
                contT1++;
            }
        }
        for(Usuario usuario: usuariosTipo2){
            if("Tipo2".equals(usuario.getTipo())){
                contT2++;
            }
        }
        assertEquals(contT1, usuariosTipo1.size());
        assertEquals(contT2, usuariosTipo2.size());
    }




}

