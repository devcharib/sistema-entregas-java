package com.charlly.sistema_entregas.exception;
//revisao
public class MotoristaSemEntregaException extends RuntimeException{
    
    public MotoristaSemEntregaException(String motorista) {
        super("Motorista sem entregas com o nome: " + motorista);
    }
}
