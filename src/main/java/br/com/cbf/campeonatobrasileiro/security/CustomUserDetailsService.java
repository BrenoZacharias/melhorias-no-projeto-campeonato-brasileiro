package br.com.cbf.campeonatobrasileiro.security;

import br.com.cbf.campeonatobrasileiro.entity.Usuario;
import br.com.cbf.campeonatobrasileiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioService.findByUsername(username);

        if(usuario.isPresent()) {
            return User.builder()
                    .username(usuario.get().getUsername())
                    .password(usuario.get().getPassword())
                    .build();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");

    }
}
