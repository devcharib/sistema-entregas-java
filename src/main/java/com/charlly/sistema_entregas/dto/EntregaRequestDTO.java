package com.charlly.sistema_entregas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EntregaRequestDTO {

    // mensagens de validação @VALID
    @NotBlank(message = "Destino é obrigatório")
    private String destino;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    @NotBlank(message = "Motorista é obrigatório")
    private String motorista;
    
    @NotNull(message = "Peso é obrigatorio")
    @Positive(message = "Peso deve ser maior que zero")
    private Double peso;

    public EntregaRequestDTO() {
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
