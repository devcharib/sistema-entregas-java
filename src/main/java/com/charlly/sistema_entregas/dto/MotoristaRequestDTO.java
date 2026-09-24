package com.charlly.sistema_entregas.dto;

import jakarta.validation.constraints.NotBlank;

public class MotoristaRequestDTO {
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public MotoristaRequestDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
