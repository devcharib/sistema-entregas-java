package com.charlly.sistema_entregas.dto;

public class EntregasRequestDTO {
    private String destino;
    private String status;
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
