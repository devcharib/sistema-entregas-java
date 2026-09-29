package com.charlly.sistema_entregas.exception;

public class OrdenacaoInvalidaException extends RuntimeException{
    
    public OrdenacaoInvalidaException(String campo) {
        super("Campo de ordenação inválido: " + campo);
    }
}
