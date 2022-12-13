package com.example.TeranSofiaIntegrador.jwt;

import com.example.TeranSofiaIntegrador.repositories.UsuarioRepository;
import com.example.TeranSofiaIntegrador.roles.Roles;
import com.example.TeranSofiaIntegrador.roles.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.CheckedOutputStream;
@AllArgsConstructor
@Service

public class MyUserDetailsService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  usuarioRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("mal"));
//        return new User(usuario.getEmail(), usuario.getPass(), new ArrayList<>(usuario.getAuthorities()));
    }
    public void saveUsuario(Usuario usuario) {
        Usuario usuario1 = new Usuario(usuario.getNombre(),usuario.getEmail(), encoder.encode(usuario.getPass()), usuario.getRol());
        usuarioRepository.save(usuario1);
    }

}
