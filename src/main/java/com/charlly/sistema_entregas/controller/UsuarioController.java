package com.charlly.sistema_entregas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlly.sistema_entregas.service.UsuarioService;

import jakarta.validation.Valid;

import com.charlly.sistema_entregas.dto.UsuarioResponseDTO;
import com.charlly.sistema_entregas.dto.UsuarioRequestDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping 
    public List<UsuarioResponseDTO> listarUsuarios() {
        return service.listarTodosUsuarios();
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO novoUsuario = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    } 
}
