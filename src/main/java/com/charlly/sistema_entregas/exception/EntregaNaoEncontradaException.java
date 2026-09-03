package com.charlly.sistema_entregas.exception;

public class EntregaNaoEncontradaException extends RuntimeException{
    
    public EntregaNaoEncontradaException(Long id) {
        super("Entrega não encontrada com id: " + id);
    }
}
