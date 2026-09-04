package com.charlly.sistema_entregas.model;

public class Entrega {
    //atributos
    private Long id;
    private String destino;
    private String status;
    //revisão
    private String motorista;

    //construtor
    public Entrega(Long id, String destino, String status, String motorista) {
        this.id = id;
        this.destino = destino;
        this.status = status;
        //revisão
        this.motorista = motorista;
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
    //revisao
    public String getMotorista() {
        return motorista;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //revisao - caso o motorista fique doente/problema antes de concluir a entrega
    public void setMotorista(String motorista, String status) {
        //.equals para String
        // ==  para int, long, float
        if (status.equals("troca de motorista")) {
            this.motorista = motorista;
        }
    }
}
