package com.charlly.sistema_entregas.model;

public class Entrega {
    //atributos
    private Long id;
    private String destino;
    private String status;

    //construtor
    public Entrega(Long id, String destino, String status) {
        this.id = id;
        this.destino = destino;
        this.status = status;
    }

    //metodos
    public Long getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
