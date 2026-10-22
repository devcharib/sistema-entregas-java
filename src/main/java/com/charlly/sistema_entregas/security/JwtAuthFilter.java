
package com.charlly.sistema_entregas.security;

import com.charlly.sistema_entregas.service.TokenService;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(TokenService tokenService, UserDetailsService userDetailsService) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                String login = tokenService.extrairLogin(token);
                UserDetails usuario = userDetailsService.loadUserByUsername(login);

                UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(usuario,
                        null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticacao);
            } catch (JwtException | IllegalArgumentException | UsernameNotFoundException e) {

            }
        }

        filterChain.doFilter(request, response);
    }

}