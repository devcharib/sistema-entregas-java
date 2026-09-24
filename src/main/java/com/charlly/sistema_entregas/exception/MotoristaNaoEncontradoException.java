package com.charlly.sistema_entregas.exception;

public class MotoristaNaoEncontradoException extends RuntimeException{
    
    public MotoristaNaoEncontradoException(Long id) {
        super("Motorista não encontrado com id: " + id);
    }
}
