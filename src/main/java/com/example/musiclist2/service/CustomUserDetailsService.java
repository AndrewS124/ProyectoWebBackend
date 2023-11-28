package com.example.musiclist2.service;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository; // Suponiendo que tienes un repositorio de usuarios

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Buscar al usuario en la base de datos por su nombre de usuario o email
        Usuario usuario = userRepository.findByNombre(usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nombre de usuario o email: " + usernameOrEmail));

        // Crear un objeto UserDetails a partir de los datos del usuario obtenidos de la base de datos
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNombre())
                .password(usuario.getContraseña())
                .authorities(getAuthorities(usuario.getTipo())) // Obtiene los roles con el prefijo "ROLE_"
                .build();
    }

    private Set<GrantedAuthority> getAuthorities(String tipo) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + tipo));
        return authorities;
    }
}
