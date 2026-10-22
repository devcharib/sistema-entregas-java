package com.charlly.sistema_entregas.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlly.sistema_entregas.dto.LoginRequestDTO;
import com.charlly.sistema_entregas.dto.LoginResponseDTO;
import com.charlly.sistema_entregas.service.TokenService;

import jakarta.validation.Valid;

@RestController 
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        Authentication autenticacao = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha())
        );

        String token = tokenService.gerarToken(autenticacao.getName());
        return new LoginResponseDTO(token);

    }
}
