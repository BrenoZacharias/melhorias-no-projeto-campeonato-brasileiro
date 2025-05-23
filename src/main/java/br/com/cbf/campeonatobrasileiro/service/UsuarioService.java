package br.com.cbf.campeonatobrasileiro.service;

import br.com.cbf.campeonatobrasileiro.dto.UsuarioDTO;
import br.com.cbf.campeonatobrasileiro.entity.Usuario;
import br.com.cbf.campeonatobrasileiro.exception.UsuarioExistenteException;
import br.com.cbf.campeonatobrasileiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Usuario> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
        if (!repository.findByUsername(usuarioDTO.getUsername()).isPresent()){
            Usuario usuario = toEntity(usuarioDTO);
            String passwordCriptografada = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(passwordCriptografada);
            repository.save(usuario);
            return toDto(usuario);
        }
        throw new UsuarioExistenteException(usuarioDTO.getUsername());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuario;
    }

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        return usuarioDTO;
    }
}
