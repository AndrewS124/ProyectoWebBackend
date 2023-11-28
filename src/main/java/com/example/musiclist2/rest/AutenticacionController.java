package com.example.musiclist2.rest;

import com.example.musiclist2.dto.UsuariosDTO;
import com.example.musiclist2.jwt.JWTFiltroAutorizacion;
import com.example.musiclist2.jwt.JWTProveedorToken;
import com.example.musiclist2.jwt.JWTToken;
import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AutenticacionController {

    private final UsuarioRepository usuarioRepository; // Esto supone que tienes un repositorio para manejar usuarios

    public AutenticacionController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @CrossOrigin
    @PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> autenticar(@RequestBody UsuariosDTO usuarioDTO) {
        String nombre = usuarioDTO.getNombre();
        String contrasena = usuarioDTO.getContrasena();
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNombre(nombre);

        if (usuarioOptional.isPresent()) { Usuario usuario = usuarioOptional.get();

            // Verificar si la contraseña coincide
            if (usuario.getContraseña().equals(contrasena)) {
                // Las credenciales son correctas, generar y devolver un token
                JWTProveedorToken jwtProveedorToken = new JWTProveedorToken();
                String token = jwtProveedorToken.generateToken(nombre);
                return ResponseEntity.ok(new JWTToken(token, JWTFiltroAutorizacion.PREFIX));
            }
        }

        // Si las credenciales no son válidas, devolver un mensaje de error
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}


