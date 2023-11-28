package com.example.musiclist2.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.musiclist2.service.CustomUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.Generated;

@Component
public class JWTFiltroAutorizacion extends OncePerRequestFilter {


    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";

    private JWTProveedorToken jwtTokenProvider;
    private UserDetailsService userDetailsService;

    @Generated
    public JWTFiltroAutorizacion(JWTProveedorToken jwtTokenProvider, CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Generated
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (existeJWTToken(request)) {
                Claims claims = validarToken(request);
                if (claims.get("authorities") != null) {
                    String username = getUsername(request);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    System.out.println("UserDetails: " + userDetails);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, userDetails, userDetails.getAuthorities());
                    System.out.println("Authentication: " + auth);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    @Generated
    private Claims validarToken(HttpServletRequest request) {

        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");

        try {

            Claims claims = jwtTokenProvider.getClaims(jwtToken);
            System.out.println("Claims del token: " + claims);

            return claims;

        } catch (Exception e) {
            throw new RuntimeException("Hubo un error al validar el token", e);
        }

    }

    @Generated
    private String getUsername(HttpServletRequest request) {

        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");

        String username = jwtTokenProvider.getUsername(jwtToken);

        System.out.println("Username del token: " + username);

        return username;

    }

    @Generated
    private boolean existeJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(HEADER);
        return !(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX));
    }
}