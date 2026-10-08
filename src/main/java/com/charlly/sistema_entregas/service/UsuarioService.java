package com.charlly.sistema_entregas.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.charlly.sistema_entregas.repository.UsuarioRepository;
import com.charlly.sistema_entregas.dto.UsuarioRequestDTO;
import com.charlly.sistema_entregas.dto.UsuarioResponseDTO;
import com.charlly.sistema_entregas.model.Usuario;

@Service 
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        return repository.findAll().stream()
            .map(u -> new UsuarioResponseDTO(u.getId(),u.getLogin()))
            .toList();
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(dto.getLogin(), passwordEncoder.encode(dto.getSenha()));
        Usuario salvo = repository.save(usuario);
        return new UsuarioResponseDTO(salvo.getId(), salvo.getLogin());
    }
}
