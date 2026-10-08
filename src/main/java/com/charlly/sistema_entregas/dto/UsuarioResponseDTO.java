package com.charlly.sistema_entregas.dto;

public class UsuarioResponseDTO {
    private Long id;
    private String login;

    public UsuarioResponseDTO(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
