<<<<<<< HEAD
/*
<<<<<<< HEAD
=======

>>>>>>> efc5e56fe123792de05c875cb66d723342f6539b
package com.example.musiclist2.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.OncePerRequestFilter;
git
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "your-secret-key"; // Reemplaza con tu clave secreta

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (token != null) {
            try {
                Claims claims = parseToken(token);

                // Realiza la validación de los claims según tus requisitos.
                // Por ejemplo, podrías validar el emisor, la expiración, roles, etc.

            } catch (SignatureException e) {
                // Manejar la excepción de firma no válida
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        // Lógica para extraer el token del encabezado de autorización
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Excluye "Bearer " del token
        }
        return null;
    }

    private Claims parseToken(String token) {
        // Lógica para analizar y validar el token JWT
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}


<<<<<<< HEAD
*/
=======
/*
<<<<<<< HEAD
=======

>>>>>>> efc5e56fe123792de05c875cb66d723342f6539b
package com.example.musiclist2.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.OncePerRequestFilter;
git
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "your-secret-key"; // Reemplaza con tu clave secreta

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (token != null) {
            try {
                Claims claims = parseToken(token);

                // Realiza la validación de los claims según tus requisitos.
                // Por ejemplo, podrías validar el emisor, la expiración, roles, etc.

            } catch (SignatureException e) {
                // Manejar la excepción de firma no válida
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        // Lógica para extraer el token del encabezado de autorización
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Excluye "Bearer " del token
        }
        return null;
    }

    private Claims parseToken(String token) {
        // Lógica para analizar y validar el token JWT
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}


<<<<<<< HEAD
*/
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
