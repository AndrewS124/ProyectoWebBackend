package com.example.musiclist2.jwt;

import com.example.musiclist2.modelo.Usuario;
import com.example.musiclist2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
//aaaaa ayud
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findByCorreo(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado con email: " + email)
                );

        return new User(
                user.getCorreo(),
                user.getContraseña(),
                mapRolesToAuthorities(user.getTipo())
        );
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(String roles) {
        return Set.of(new SimpleGrantedAuthority(roles));
    }
}
