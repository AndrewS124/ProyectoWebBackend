package com.example.musiclist2.rest;

import com.example.musiclist2.dto.UsuariosDTO;
import com.example.musiclist2.jwt.JWTFiltroAutorizacion;
import com.example.musiclist2.jwt.JWTProveedorToken;
import com.example.musiclist2.jwt.JWTToken;
import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.modelo.UsuarioVotante;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioRepository usuarioRepository;

    public RegistroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private JWTProveedorToken jwtProveedorToken; // Inyecta el proveedor de tokens JWT

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        String nombre = usuarioDTO.getNombre();
        String contrasena = usuarioDTO.getContrasena();
        String correo = usuarioDTO.getCorreo();

        // Verificar si el usuario ya existe en la base de datos
        Optional<Usuario> usuarioExistente = usuarioRepository.findByNombre(nombre);
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }

        UsuarioVotante nuevoUsuario = new UsuarioVotante(nombre, correo, contrasena, true, true, null);
        usuarioRepository.save(nuevoUsuario);

        String token = jwtProveedorToken.generateToken(nombre);

        return ResponseEntity.status(HttpStatus.CREATED).body(new JWTToken(token, JWTFiltroAutorizacion.PREFIX));
    }
}

