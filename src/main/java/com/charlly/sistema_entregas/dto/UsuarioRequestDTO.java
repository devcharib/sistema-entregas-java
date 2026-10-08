package com.charlly.sistema_entregas.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {
    
    @NotBlank(message = "Login é Obrigatório")
    private String login;

    @NotBlank(message = "Senha é Obrigatório")
    private String senha;

    public UsuarioRequestDTO () {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
