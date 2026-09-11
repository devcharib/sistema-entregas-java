package com.charlly.sistema_entregas.dto;

import jakarta.validation.constraints.NotBlank;

public class EntregasRequestDTO {

    // mensagens de validação @VALID
    @NotBlank(message = "Destino é obrigatório")
    private String destino;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    @NotBlank(message = "Motorista é obrigatório")
    private String motorista;

    public EntregasRequestDTO() {
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
}
