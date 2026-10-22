package com.charlly.sistema_entregas.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.charlly.sistema_entregas.repository.UsuarioRepository;
import com.charlly.sistema_entregas.model.Usuario;

@Service
public class AutenticacaoService implements UserDetailsService{
    
    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));

        return User.withUsername(usuario.getLogin())
            .password(usuario.getSenha())
            .roles("USER")
            .build();
            
    }

}
