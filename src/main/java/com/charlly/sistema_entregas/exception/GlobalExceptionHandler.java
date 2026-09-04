package com.charlly.sistema_entregas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntregaNaoEncontradaException.class)
    public ResponseEntity<String> tratarEntregaNaoEncontrada(EntregaNaoEncontradaException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
    }

    //revisao
    @ExceptionHandler(MotoristaSemEntregaException.class)
    public ResponseEntity<String> tratarMotoristaNaoEncontrado(MotoristaSemEntregaException ex) {
        return  ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
    }
}
