package com.charlly.sistema_entregas.model;

// transformando a classe para o HIBERNATE
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Entrega {
    //atributos
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;
    private String status;
    //revisão
    private String motorista;

    //construtor
    //para o JPA
    public Entrega() {

    }
    // sem ID porque sera criado pelo banco auto
    public Entrega(String destino, String status, String motorista) {
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
