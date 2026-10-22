package com.charlly.sistema_entregas.repository;

import com.charlly.sistema_entregas.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);
}
