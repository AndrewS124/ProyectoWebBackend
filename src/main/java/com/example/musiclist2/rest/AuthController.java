package com.example.musiclist2.rest;

import com.example.musiclist2.dto.AuthR_DTO;
import com.example.musiclist2.dto.LoginDTO;
import com.example.musiclist2.dto.RegisterDTO;
import com.example.musiclist2.jwt.JwtGenerator;
import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    private JwtGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {

        if (usuarioRepository.existsByCorreo(registerDTO.getEmail())) {
            return new ResponseEntity<>("El correo ya existe", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(registerDTO.getNombre());
        usuario.setCorreo(registerDTO.getEmail());
        usuario.setContraseña(passwordEncoder.encode(registerDTO.getPassword()));
        usuario.setAutenticacion(true);
        usuario.setTipo(registerDTO.getTipo());

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthR_DTO> login(@RequestBody LoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthR_DTO(token), HttpStatus.OK);

    }
}
