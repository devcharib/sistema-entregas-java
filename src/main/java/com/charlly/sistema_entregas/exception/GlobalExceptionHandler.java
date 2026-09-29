package com.charlly.sistema_entregas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;


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
    public ResponseEntity<String> tratarMotoristaSemEntrega(MotoristaSemEntregaException ex) {
        return  ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
    }

    //motorista
    @ExceptionHandler(MotoristaNaoEncontradoException.class)
    public ResponseEntity<String> tratarMotoristaNaoEncontrado(MotoristaNaoEncontradoException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
    }

    //ValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErrosValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro ->
            erros.put(erro.getField(), erro.getDefaultMessage())
        );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(erros);
    }

    //Ordenação
    @ExceptionHandler(OrdenacaoInvalidaException.class)
    public ResponseEntity<String> tratarOrdenacaoInvalida(OrdenacaoInvalidaException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
    }

}
