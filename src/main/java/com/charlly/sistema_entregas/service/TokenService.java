package com.charlly.sistema_entregas.service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
    
    private final SecretKey chave;
    private final long expiracaoMinutos;

    public TokenService(@Value("${jwt.secret}") String segredo,
                        @Value("${jwt.expiration-minutes}") long expiracaoMinutos) {
        this.chave = Keys.hmacShaKeyFor(segredo.getBytes(StandardCharsets.UTF_8));
        this.expiracaoMinutos = expiracaoMinutos;
    }

    public String gerarToken(String login) {
        Instant agora = Instant.now();
        return Jwts.builder()
            .subject(login)
            .issuedAt(Date.from(agora))
            .expiration(Date.from(agora.plus(expiracaoMinutos, ChronoUnit.MINUTES)))
            .signWith(chave)
            .compact();
    }

    public String extrairLogin(String token) {
        return Jwts.parser()
            .verifyWith(chave)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
}
