package com.example.musiclist2.rest;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserDataController {

    private static final String SECRET_KEY = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb" ;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @CrossOrigin
    @GetMapping("/userData")
    public ResponseEntity<?> getUserData(HttpServletRequest request) {
        String token = extractTokenFromHeader(request.getHeader("Authorization"));

        if (token != null) {
            String username = getUsernameFromToken(token);
            Usuario usuario = usuarioRepo.findByNombre(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Crear un objeto JSON con los datos del usuario que deseas devolver al frontend
            Map<String, Object> userData = new HashMap<>();
            userData.put("nombre", usuario.getNombre());
            userData.put("correo", usuario.getCorreo());
            userData.put("tipo", usuario.getTipo());
            // Agrega más campos si son necesarios

            return ResponseEntity.ok(userData);
        } else {
            // Manejar el caso en el que no se proporciona un token válido
            return ResponseEntity.status(401).body("Token no válido o no proporcionado");
        }
    }

    // Método para extraer el token del encabezado
    private String extractTokenFromHeader(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // Remover el prefijo "Bearer "
        }
        return null;
    }

    private Key key(){
        return Keys.hmacShaKeyFor( Decoders.BASE64.decode(SECRET_KEY));
    }

    // Método para obtener el nombre de usuario a partir del token
    private String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
            return claims.getSubject(); // Suponiendo que el nombre de usuario está en el campo 'sub'
        } catch (Exception e) {
            // Manejar cualquier error al parsear el token
            return null;
        }
    }

}

