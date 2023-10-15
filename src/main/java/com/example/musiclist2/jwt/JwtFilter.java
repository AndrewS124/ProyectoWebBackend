/*

package com.example.musiclist2.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (token != null) {
            Claims claims = parseToken(token);
            // Realiza la validación de los claims según tus requisitos.
        }
        filterChain.doFilter(request, response);
    }

    // Implementa los métodos extractToken y parseToken para extraer y validar el token JWT.
}

*/